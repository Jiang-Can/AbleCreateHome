package com.HospitalManage.model;

import com.HospitalManage.bean.patient.Patient;

import java.util.List;

public class PatientModel extends BaseModel{


    public List<Patient> findAllPatients(){
        String sql = "select patient_id as patientid,name,gender,isolation,bed_no as bedno from patient";
        return queryAllForList(Patient.class,sql);
    }
    public int addNewPatient(Patient patient){
        String sql = "insert into patient (name, gender, isolation, bed_no) values (?,?,?,?)";
        return update(sql,patient.getName(),patient.getGender(),patient.getIsolation(),patient.getBedNo());
    }
}
