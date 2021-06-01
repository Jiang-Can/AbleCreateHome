package com.HospitalManage.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static LocalTime parseToLocalTime(String time){
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("H:m"));
    }
}
