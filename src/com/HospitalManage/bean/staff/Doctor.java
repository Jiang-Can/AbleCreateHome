package com.HospitalManage.bean.staff;

import com.HospitalManage.bean.misc.Prescription;
import com.HospitalManage.bean.patient.Patient;

public class Doctor extends Staff{

    public Doctor(Long id, String name, String password) {
        super(id, name, password);
    }

    public void attachPrescription(Prescription prescription, Patient patient){
        patient.setPrescription(prescription);
    }
}
