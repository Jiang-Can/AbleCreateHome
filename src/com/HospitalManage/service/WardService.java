package com.HospitalManage.service;

import com.HospitalManage.Exception.BedUnavailableException;
import com.HospitalManage.bean.accomodation.Bed;
import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.model.PatientModel;
import com.HospitalManage.model.WardModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WardService {

    private Map<String, Room> roomMap;

    private Map<String, Bed> bedMap;

    private Map<String, Patient> patientMap;

    private WardModel wardModel;

    private PatientModel patientModel;


    public WardService(){
        wardModel = new WardModel();
        patientModel = new PatientModel();
        bedMap = new HashMap<>();
        roomMap = new HashMap<>();
        patientMap = new HashMap<>();
        initializeMaps();
    }

    public void addPatientToTheBed(Patient patient){
        //validating for patient and bed
        if(!bedMap.containsKey(patient.getBedNo())){
            throw new BedUnavailableException("Invalid bedNo");
        }
        Bed bed = bedMap.get(patient.getBedNo());
        if(bed.getOccupy()){
            throw new BedUnavailableException("This bed has been occupied");
        }
        Room room = roomMap.get(patient.getBedNo().substring(0,3));
        if(room.getIsolation()){
            throw new BedUnavailableException("This room has patient need to be isolation");
        }
        if(room.getGender()!=null&&
                !room.getGender().equals(patient.getGender())){
            throw new BedUnavailableException("This room is only available for "+room.getGender());
        }
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
        patientModel.addNewPatient(patient);
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
}
