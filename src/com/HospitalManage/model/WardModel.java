package com.HospitalManage.model;

import com.HospitalManage.bean.accomodation.Bed;
import com.HospitalManage.bean.accomodation.Room;
import com.HospitalManage.bean.patient.Gender;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class WardModel extends BaseModel{

    //Dao operation for Room

    public List<Room> findAllRooms(){
        String sql = "select room_no as roomNo,isolation,gender,occupied from room";
        return queryAllForList(Room.class, sql);
    }

    public int setGenderAndIsolationByRoomNo(Room room){
        String sql = "update room set gender=?,isolation=? where room_no=?";
        return update(sql,room.getGender(),room.getIsolation(),room.getRoomNo());
    }

    public int addOneOccupiedByRoomNo(String roomNo){
        String sql = "update room set occupied=occupied+1 where room_no=?";
        return update(sql,roomNo);
    }

    public int minusOneOccupiedByRoomNo(String roomNo){
        String sql = "update room set occupied=occupied+1 where room_no=?";
        return update(sql,roomNo);
    }


    //Dao operation for Bed

    public List<Bed> findAllBeds(){
        String sql = "select bed_no as bedno, occupy, room_no as roomno from bed";
        return queryAllForList(Bed.class,sql);
    }

    public int setOccupyByBedNo(boolean occupy,String bedNo){
        String sql ="update bed set occupy=? where bed_no=?";
        return update(sql,occupy,bedNo);
    }

}
