package com.HospitalManage.service;

import com.HospitalManage.Exception.ActionUnauthorizedException;
import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.misc.Prescription;
import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Job;
import com.HospitalManage.bean.staff.Staff;

import java.util.HashMap;
import java.util.Map;

public class ActionService implements StaffAction{

    private Integer loginId;

    private Map<Integer,Staff> staffMap;

    private Map<Integer,Staff> addedStaff = new HashMap<>();

    private Map<Integer,Patient> patientMap;

    private Map<Integer,Patient> addedPatient;


    @Override
    public void addNewStaff(Staff staff) {
        if(!Job.MANAGER.toString().equals(staffMap.get(loginId).getJob())){
            throw new ActionUnauthorizedException("Not manager is not authorized to add new staff");
        }
        addedStaff.put(staff.getId(),staff);
    }

    @Override
    public void modifyStaff(Staff staff) {
        if(!Job.MANAGER.toString().equals(staffMap.get(loginId).getJob())){
            throw new ActionUnauthorizedException("Not manager is not authorized to add new staff");
        }
        if(staffMap.containsKey(staff.getId())){
            staffMap.put(staff.getId(),staff);
        }else {
            addedStaff.put(staff.getId(),staff);
        }
    }

    @Override
    public void addResidentToBed(Patient patient) {
        if(!Job.MANAGER.toString().equals(staffMap.get(loginId).getJob())){
            throw new ActionUnauthorizedException("Not Doctor is not authorized to add new staff");
        }
    }

    @Override
    public void attachNewPrescription(Staff staff, Patient patient, Prescription prescription) {
        if(!Job.DOCTOR.toString().equals(staffMap.get(loginId).getJob())){
            throw new ActionUnauthorizedException("Not Doctor is not authorized to add new staff");
        }
    }

    @Override
    public void updatePrescription(Staff staff, Patient patient, Prescription prescription) {
        if(!Job.DOCTOR.toString().equals(staffMap.get(loginId).getJob())){
            throw new ActionUnauthorizedException("Not Doctor is not authorized to add new staff");
        }
    }

    @Override
    public void movePatientToDifferentBed(Staff staff, Patient patient, Room room, int bedNumber) {
        if(!Job.NURSE.toString().equals(staffMap.get(loginId).getJob())){
            throw new ActionUnauthorizedException("Not nurse is not authorized to add new staff");
        }
    }

    @Override
    public Patient checkPatientDetailsByBedNumber(Room room, int bedNumber) {

        return null;
    }
}
