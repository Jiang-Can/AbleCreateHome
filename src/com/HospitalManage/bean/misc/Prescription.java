package com.HospitalManage.bean.misc;

import com.HospitalManage.bean.staff.Staff;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    private Integer prescriptionId;

    private Integer doctorId;

    private Integer patientId;

    private String medicine;

    private Double doses;

    private LocalTime time;

    public Prescription(Integer doctorId, Integer patientId, String medicine, Double doses, LocalTime time) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.medicine = medicine;
        this.doses = doses;
        this.time = time;
    }
}
