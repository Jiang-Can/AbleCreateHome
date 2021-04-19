package com.HospitalManage.service;

import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Staff;

public interface ManagerAction {

    void addNewStaff(Staff staff);

    void modifyStaff(Staff staff);

    void addResidentToBed(Patient patient);
}
