package com.HospitalManage.utils;

import com.HospitalManage.bean.staff.Job;

import java.util.Arrays;

public class ValidationUtils {

    public static void jobValidation(String actualJob,Job ...neededJob) throws Exception {
        String errMsg = "This action is permitted with "+Arrays.toString(neededJob);
        boolean flag = false;
        for(Job job:neededJob){
            if(job.toString().equals(actualJob)) {
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new Exception(errMsg);
        }
    }
}
