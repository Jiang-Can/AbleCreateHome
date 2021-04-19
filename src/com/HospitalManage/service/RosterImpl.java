package com.HospitalManage.service;

import com.HospitalManage.bean.misc.WorkTime;
import com.HospitalManage.bean.staff.Doctor;
import com.HospitalManage.bean.staff.Nurse;

import java.util.Map;
import java.util.Queue;

public class RosterImpl implements Roster{


    Queue<Doctor> readyToRoster = null;

    @Override
    public Map<WorkTime, Nurse> assignWorkTimeToNurses() {
        return null;
    }

    @Override
    public Map<WorkTime, Doctor> assignWorkTimeToDoctor() {
        return null;
    }
}
