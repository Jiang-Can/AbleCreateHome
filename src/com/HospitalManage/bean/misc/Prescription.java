package com.HospitalManage.bean.misc;

import com.HospitalManage.bean.staff.Staff;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Map;

@Getter
@Setter
public class Prescription {

    private Long prescriptionId;

    private Staff doctor;

    /*
    * String store the medicine name
    * the Map<Double, LocalTime> store different doses at different time
    * */
    private Map<String,Map<Double, LocalTime>> medicinesDetails;
}
