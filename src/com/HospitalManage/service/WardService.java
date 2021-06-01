package com.HospitalManage.service;

import com.HospitalManage.Exception.BedUnavailableException;
import com.HospitalManage.bean.accomodation.Bed;
import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.misc.Prescription;
import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.model.PatientModel;
import com.HospitalManage.model.PrescriptionModel;
import com.HospitalManage.model.WardModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WardService {

    /*
    * key: roomNo
    * value: room entity
    * */
    private Map<String, Room> roomMap;

    /*
     * key: bedNo
     * value: bed entity
     * */
    private Map<String, Bed> bedMap;

    /*
     * key: bedNo
     * value: patient entity
     * */
    private Map<String, Patient> patientMap;

    private WardModel wardModel;

    private PatientModel patientModel;

    private PrescriptionModel prescriptionModel;


    public WardService(){
        wardModel = new WardModel();
        patientModel = new PatientModel();
        prescriptionModel = new PrescriptionModel();
        bedMap = new HashMap<>();
        roomMap = new HashMap<>();
        patientMap = new HashMap<>();
        initializeMaps();
    }

    public void movePatientToTargetBed(Patient patient,String targetBedNo){
        moveOutPatient(patient);
        String originBedNo = patient.getBedNo();
        //change patient bedNo
        patient.setBedNo(targetBedNo);
        moveInPatient(patient);
        //change patient bedNo in database
        patientModel.changePatientBedNo(originBedNo,targetBedNo);
    }

    public void moveOutPatientFromHospital(Patient patient){
        moveOutPatient(patient);
        //delete patient from database
        patientModel.deletePatientByBedNo(patient.getBedNo());
    }

    public void addPatientToTheBed(Patient patient){
        moveInPatient(patient);
        // get the auto generated id from database and set it in map
        int patientId = patientModel.addNewPatient(patient);
        patientMap.get(patient.getBedNo()).setPatientId(patientId);
    }

    /*
    * update all the information in maps about move out patient action
    * But do not update patient in database
    * */
    private void moveOutPatient(Patient patient){
        patientMap.remove(patient.getBedNo());
        bedMap.get(patient.getBedNo()).setOccupy(false);
        Room room = roomMap.get(patient.getBedNo().substring(0,3));
        if(room.getOccupied()==1){
            room.setOccupied(0);
            room.setGender(null);
            room.setIsolation(false);
            wardModel.setRoomToDefaultStatus(room);
        }else {
            room.setOccupied(room.getOccupied()-1);
        }
        wardModel.setOccupyByBedNo(false,patient.getBedNo());
        roomMap.put(room.getRoomNo(), room);
    }

    /*
    * update all the information in maps about move in patient action
    * But do not update patient in database
    * */
    private void moveInPatient(Patient patient){
        //validating for patient and bed
        containsBedNoValidation(patient.getBedNo());
        Room room = roomMap.get(patient.getBedNo().substring(0,3));
        Bed bed = bedMap.get(patient.getBedNo());
        if(bed.getOccupy()){
            throw new BedUnavailableException("This bed has been occupied");
        }
        roomAvailableValidation(patient,room);
        //update the data in maps
        patientMap.put(patient.getBedNo(),patient);
        room.setGender(patient.getGender());
        room.setIsolation(patient.getIsolation());
        room.setOccupied(room.getOccupied()+1);
        roomMap.put(room.getRoomNo(),room);
        bed.setOccupy(true);
        bedMap.put(bed.getBedNo(),bed);
        //update the data in database
        wardModel.setOccupyByBedNo(true,bed.getBedNo());
        wardModel.addOneOccupiedByRoomNo(room.getRoomNo());
        wardModel.setGenderAndIsolationByRoomNo(room);
    }

    private void containsBedNoValidation(String bedNo){
        if(!bedMap.containsKey(bedNo)){
            throw new BedUnavailableException("Invalid bedNo");
        }
    }

    private void roomAvailableValidation(Patient patient,Room room){
        if(room.getIsolation()){
            throw new BedUnavailableException("This room has patient need to be isolation");
        }
        if(patient.getIsolation()&&room.getOccupied()>0){
            throw new BedUnavailableException("Patient who need to be isolated should live alone");
        }
        if(room.getGender()!=null&&
                !room.getGender().equals(patient.getGender())){
            throw new BedUnavailableException("This room is only available for "+room.getGender());
        }
    }

    public Map<String,Patient> getPatientMap(){
        return patientMap;
    }

    private void initializeMaps(){
        List<Room> rooms = wardModel.findAllRooms();
        List<Bed> beds = wardModel.findAllBeds();
        List<Patient> patients = patientModel.findAllPatients();

        rooms.forEach(room ->roomMap.put(room.getRoomNo(), room));
        beds.forEach(bed ->bedMap.put(bed.getBedNo(),bed));
        patients.forEach(patient -> patientMap.put(patient.getBedNo(),patient));
    }

    public int addNewPrescription(Prescription prescription){
        return prescriptionModel.addPrescription(prescription);
    }
}
