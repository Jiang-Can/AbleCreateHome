package com.HospitalManage.bean.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private Integer patientId;
    private String name;
    private String gender;
    private Boolean isolation;
    private String bedNo;

    public Patient(String name, String gender, Boolean isolation, String bedNo) {
        this.name = name;
        this.gender = gender;
        this.isolation = isolation;
        this.bedNo = bedNo;
    }
}
