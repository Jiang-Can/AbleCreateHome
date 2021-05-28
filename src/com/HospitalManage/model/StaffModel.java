package com.HospitalManage.model;

import com.HospitalManage.bean.staff.Staff;

import java.util.List;

public class StaffModel extends BaseModel{

    public Staff findStaffById(Integer id){
        String sql = "select * from staff where id=?";
        return queryForOne(Staff.class,sql,id);
    }

    public List<Staff> findAllStaff(){
        String sql = "select * from staff";
        return queryAllForList(Staff.class,sql);
    }

    public int addNewStaff(Staff staff){
        String sql = "insert into staff (name, password, job) values (?,?,?)";
        return update(sql,staff.getName(),staff.getPassword(),staff.getJob());
    }

    public int updateStaff(Staff staff){
        String sql = "update staff set name=?,password=?,job=? where id =?";
        return update(sql,staff.getName(),staff.getPassword(),staff.getJob(),staff.getId());
    }

    public int getNewStaffId(){
        String sql = "select max(id)from staff";
        return (int)queryForSingleValue(sql);
    }

}
