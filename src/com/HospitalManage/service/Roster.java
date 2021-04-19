package com.HospitalManage.service;

import com.HospitalManage.bean.misc.WorkTime;
import com.HospitalManage.bean.staff.Doctor;
import com.HospitalManage.bean.staff.Nurse;

import java.util.Map;
import java.util.Queue;

public interface Roster {

     Map<WorkTime, Nurse> assignWorkTimeToNurses();

     Map<WorkTime, Doctor> assignWorkTimeToDoctor();
}
