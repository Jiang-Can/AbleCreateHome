package com.HospitalManage.bean.accomodation;



import java.util.ArrayList;
import java.util.List;

public class Ward {
    private List<Room> wards;

    public Ward(){
        initializeWards();
    }
    private void initializeWards(){
        wards = new ArrayList<>();
        wards.add(new Room("1-1",1));
        wards.add(new Room("1-2",2));
        wards.add(new Room("1-3",4));
        wards.add(new Room("1-4",4));
        wards.add(new Room("1-5",4));
        wards.add(new Room("1-6",4));
        wards.add(new Room("2-1",1));
        wards.add(new Room("2-2",2));
        wards.add(new Room("2-3",4));
        wards.add(new Room("2-4",4));
        wards.add(new Room("2-5",4));
        wards.add(new Room("2-6",4));
    }
}
