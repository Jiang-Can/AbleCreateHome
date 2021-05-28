package com.HospitalManage.utils;

import com.HospitalManage.bean.staff.Job;

public class ValidationUtils {

    public static void managerValidation(String job) throws Exception {
        if(!Job.MANAGER.toString().equals(job)){
            throw new Exception("Only manager can add new patient (resident)");
        }
    }
}
