package com.HospitalManage.service;

import com.HospitalManage.bean.misc.Shift;
import com.HospitalManage.bean.staff.Staff;

import java.util.Map;

public interface Roster {

     Map<Shift, Staff> assignWorkTimeToNurses();

     Map<Shift, Staff> assignWorkTimeToDoctor();
}
