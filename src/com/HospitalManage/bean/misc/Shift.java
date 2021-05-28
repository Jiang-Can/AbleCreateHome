package com.HospitalManage.bean.misc;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
public class Shift {

    Date startTime;
    Date endTime;
    int maxHour;
}
