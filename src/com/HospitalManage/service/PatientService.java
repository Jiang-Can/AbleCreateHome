package com.HospitalManage.service;

import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.model.PatientModel;

public class PatientService {

    private PatientModel patientModel;

    public PatientService(){
        patientModel = new PatientModel();
    }

    public int addNewPatient(Patient patient){
        return patientModel.addNewPatient(patient);
    }
}
