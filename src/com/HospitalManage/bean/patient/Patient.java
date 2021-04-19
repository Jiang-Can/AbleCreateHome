package com.HospitalManage.bean.patient;

import com.HospitalManage.bean.misc.Prescription;
import lombok.Data;


@Data
public class Patient {
    private Long patientId;
    private String name;
    private Gender gender;
    private Boolean isolation;
    private Prescription prescription;
    private String roomPosition;
    private int bedNumber;


    public Patient(Long patientId, String name, Gender gender, Boolean isolation) {
        this.patientId = patientId;
        this.name = name;
        this.gender = gender;
        this.isolation = isolation;
    }

    public Patient(Long patientId, String name, Gender gender, Boolean isolation, Prescription prescription) {
        this.patientId = patientId;
        this.name = name;
        this.gender = gender;
        this.isolation = isolation;
        this.prescription = prescription;
    }

}
