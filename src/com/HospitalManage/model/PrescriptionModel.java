package com.HospitalManage.model;

import com.HospitalManage.bean.misc.Prescription;

public class PrescriptionModel extends BaseModel{

    public int addPrescription(Prescription prescription){
        String addSql = "insert into prescription (doctor_id, patient_id, medicine, doses, time) values (?,?,?,?,?)";
        String getIdSql = "select  max(pres_id) from prescription";
        update(addSql, prescription.getDoctorId(),
                prescription.getPatientId(),prescription.getMedicine(),
                prescription.getDoses(),prescription.getTime());
        return (int)queryForSingleValue(getIdSql);
    }
}
