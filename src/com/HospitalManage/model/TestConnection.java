package com.HospitalManage.model;

import com.HospitalManage.bean.accomodation.Bed;
import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.misc.Prescription;
import com.HospitalManage.bean.patient.Gender;
import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.PatientService;
import com.HospitalManage.utils.DateTimeUtils;
import com.HospitalManage.utils.JDBCUtils;

import javax.naming.ldap.HasControls;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        WardModel wardModel = new WardModel();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");
        LocalTime localTime1 = LocalTime.of(1,2);
        LocalTime localTime2 = LocalTime.of(23,1);
        Long s = localTime1.until(localTime2, ChronoUnit.MINUTES);
        PrescriptionModel p = new PrescriptionModel();
        p.addPrescription(new Prescription(1,1,"sd", 10.0, LocalTime.of(1,2)));
    }


}
