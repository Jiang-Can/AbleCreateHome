package com.HospitalManage.model;

import com.HospitalManage.bean.accomodation.Bed;
import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.patient.Gender;
import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.PatientService;
import com.HospitalManage.utils.JDBCUtils;

import javax.naming.ldap.HasControls;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        WardModel wardModel = new WardModel();
        StaffModel staffModel = new StaffModel();
        System.out.println(staffModel.getNewStaffId());


    }


}
