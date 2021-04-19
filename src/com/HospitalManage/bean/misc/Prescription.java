package com.HospitalManage.bean.misc;

import com.HospitalManage.bean.staff.Doctor;
import lombok.Data;
import java.time.LocalTime;
import java.util.Map;

@Data
public class Prescription {
    private Long prescriptionId;
    private Doctor doctor;
    private Map<String,Map<Double, LocalTime>> medicinesDetails;
}
