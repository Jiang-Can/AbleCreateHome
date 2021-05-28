package com.HospitalManage.bean.accomodation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Room {

    private String roomNo;

    private String gender;

    private Boolean isolation;

    private Integer occupied;

    public Room(String roomNo) {
        roomNo = roomNo;
        occupied = 0;
    }

    /*    public boolean addPatient(Patient patient) {
        if (isolation ||
                (gender!= null && patient.getGender() != gender) ||
                patients.size() >= capacity ||
                (patient.getIsolation() && patients.size() > 0)) {
            return false;
        }
        gender = patient.getGender();
        isolation = patient.getIsolation();
        patients.add(patient);
        assignToBed(patient);
        return true;
    }

    private void assignToBed(Patient patient){
        for(int i=0;i<capacity;i++){
            if(!beds[i]) {
                patient.setBed(new Bed(position,i));
                beds[i] = true;
            }
        }
    }*/

}
