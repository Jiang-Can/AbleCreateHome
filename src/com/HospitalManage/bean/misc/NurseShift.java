package com.HospitalManage.bean.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NurseShift {

    private Integer shiftId;

    private String shiftCode;

    private Integer day;

    private Integer staffId;

    public NurseShift(String shiftCode, Integer day, Integer staffId) {
        this.shiftCode = shiftCode;
        this.day = day;
        this.staffId = staffId;
    }

}
