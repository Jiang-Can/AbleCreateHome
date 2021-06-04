package com.HospitalManage.model;

import com.HospitalManage.bean.misc.NurseShift;

import java.util.List;

public class NurseShiftModel extends BaseModel{

    public void addNurseShift(NurseShift nurseShift){
        String sql = "insert into nurse_shift (shift_code, day, staff_id) values (?,?,?)";
        update(sql,nurseShift.getShiftCode(),nurseShift.getDay(),nurseShift.getStaffId());
    }

    public void deleteNurseShift(NurseShift nurseShift){
        String sql = "delete from nurse_shift where shift_code=? and staff_id=?";
        update(sql,nurseShift.getShiftCode(),nurseShift.getStaffId());
    }

    // use for checkCompliance()
    public NurseShift checkNurseShift(NurseShift nurseShift){
        String sql = "select shift_id as shiftId,shift_code as shiftcode," +
                "day,staff_id as staffid from nurse_shift where day=? and staff_id=?";
        return queryForOne(NurseShift.class,sql,nurseShift.getDay(),nurseShift.getStaffId());
    }

    public List<NurseShift> findAllNurseShiftByShiftCode(String shiftCode){
        String sql = "select shift_id as shiftId,shift_code as shiftcode," +
                "day,staff_id as staffid from nurse_shift where shift_code=?";
        return queryForList(NurseShift.class,sql,shiftCode);
    }
}
