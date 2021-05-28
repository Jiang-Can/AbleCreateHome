package com.HospitalManage.service;

import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.model.StaffModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffService {

    private final StaffModel staffModel;

    private Map<Integer,Staff> staffMap;

    public StaffService(){
        staffModel = new StaffModel();
        staffMap = new HashMap<>();
        initializeStaffMap();
    }

    public int addNewStaff(Staff staff){
        staffModel.addNewStaff(staff);
        int id = staffModel.getNewStaffId();
        staff.setId(id);
        staffMap.put(staff.getId(), staff);
        return id;
    }

    public void updateStaff(Staff staff) throws Exception {
        if(!staffMap.containsKey(staff.getId())){
            throw new Exception("Please enter correct staff id");
        }
        staffModel.updateStaff(staff);
        staffMap.put(staff.getId(), staff);
    }

    public Staff getStaffById(Integer id){
        return staffModel.findStaffById(id);
    }

    private void initializeStaffMap(){
        List<Staff> staffs = staffModel.findAllStaff();
        staffs.forEach(staff -> staffMap.put(staff.getId(), staff));
    }

    public Map<Integer,Staff> getStaffMap(){
        return staffMap;
    }

}
