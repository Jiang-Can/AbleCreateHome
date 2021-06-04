package com.HospitalManage.service;

import com.HospitalManage.Exception.MismatchedScheduleException;
import com.HospitalManage.bean.misc.NurseShift;
import com.HospitalManage.model.NurseShiftModel;

public class CareHome {


    public static void checkCompliance(NurseShift nurseShift, NurseShiftModel model){
        if(model.checkNurseShift(nurseShift)!=null){
            throw new MismatchedScheduleException("Can not assign shift for one nurse over 8 hours");
        }
    }
}
