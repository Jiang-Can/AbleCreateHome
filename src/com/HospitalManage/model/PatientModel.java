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
        update(sql,patient.getName(),patient.getGender(),patient.getIsolation(),patient.getBedNo());
        return getNewPatientId();
    }
    public int getNewPatientId(){
        String sql = "select max(patient_id) from patient";
        return (int)queryForSingleValue(sql);
    }

    public int deletePatientByBedNo(String bedNo){
        String sql = "delete from patient where bed_no=?";
        return update(sql,bedNo);
    }

    public int changePatientBedNo(String originBedNo,String targetBedNo){
        String sql = "update patient set bed_no=? where bed_no=?";
        return update(sql,targetBedNo,originBedNo);
    }
}
