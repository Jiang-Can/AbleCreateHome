package com.HospitalManage.service;

import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.misc.Prescription;
import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Staff;

public interface StaffAction {

    void attachNewPrescription(Staff staff,Patient patient, Prescription prescription);

    void updatePrescription(Staff staff,Patient patient, Prescription prescription);

    void movePatientToDifferentBed(Staff staff,Patient patient,Room room,int bedNumber);

    Patient checkPatientDetailsByBedNumber(Staff staff,Room room,int bedNumber);
}
