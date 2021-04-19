package com.HospitalManage.bean.accomodation;

import com.HospitalManage.bean.patient.Gender;
import com.HospitalManage.bean.patient.Patient;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private String position;
    private Integer capacity;
    private Gender gender;
    private Boolean isolation;
    private List<Patient> patients;
    private Boolean[] beds;

    public Room(String position, int capacity) {
        this.position = position;
        this.capacity = capacity;
        this.isolation = false;
        beds = new Boolean[capacity];
        patients = new ArrayList<>();
    }

    public boolean addPatient(Patient patient) {
        if (isolation ||
                (gender!= null && patient.getGender() != gender) ||
                patients.size() >= capacity ||
                (patient.getIsolation() && patients.size() > 0)) {
            return false;
        }
        patient.setRoomPosition(position);
        gender = patient.getGender();
        isolation = patient.getIsolation();
        patients.add(patient);
        assignToBed(patient);
        return true;
    }

    private void assignToBed(Patient patient){
        for(int i=0;i<capacity;i++){
            if(!beds[i]) {
                patient.setBedNumber(i);
                beds[i] = true;
            }
        }
    }

}
