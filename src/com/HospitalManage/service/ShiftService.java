package com.HospitalManage.service;

import com.HospitalManage.bean.misc.NurseShift;
import com.HospitalManage.model.NurseShiftModel;

import java.util.List;

public class ShiftService {

    private NurseShiftModel nurseShiftModel;

    public ShiftService(){
        nurseShiftModel = new NurseShiftModel();
    }

    public void addNurseShift(NurseShift nurseShift){
        CareHome.checkCompliance(nurseShift,nurseShiftModel);
        nurseShiftModel.addNurseShift(nurseShift);
    }

    public String getNurseShiftDetailsByShiftCode(String shiftCode){
        List<NurseShift> nurseShifts = nurseShiftModel.findAllNurseShiftByShiftCode(shiftCode);
        StringBuilder details = new StringBuilder();
        nurseShifts.forEach(shift->{
            details.append(shift.getStaffId()).append(", ");
        });
        return details.toString();
    }
}
