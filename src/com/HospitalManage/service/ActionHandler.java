package com.HospitalManage.service;

import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.misc.Prescription;
import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Staff;

public class ActionHandler implements ManagerAction,StaffAction{



    @Override
    public void addNewStaff(Staff staff) {

    }

    @Override
    public void modifyStaff(Staff staff) {

    }

    @Override
    public void addResidentToBed(Patient patient) {

    }

    @Override
    public void attachNewPrescription(Staff staff, Patient patient, Prescription prescription) {

    }

    @Override
    public void updatePrescription(Staff staff, Patient patient, Prescription prescription) {

    }

    @Override
    public void movePatientToDifferentBed(Staff staff, Patient patient, Room room, int bedNumber) {

    }

    @Override
    public Patient checkPatientDetailsByBedNumber(Staff staff, Room room, int bedNumber) {
        return null;
    }
}
