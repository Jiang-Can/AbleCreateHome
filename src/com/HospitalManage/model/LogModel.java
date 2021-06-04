package com.HospitalManage.model;

import com.HospitalManage.bean.misc.Log;

import java.util.List;

public class LogModel extends BaseModel{

    public void addNewLog(Log log){
        String sql = "insert into log (staffid, time, description) values (?,?,?)";
        update(sql, log.getStaffId(),log.getTime(),log.getDescription());
    }

    public List<Log> getAllLog(){
        String sql = "select logid,staffid,description from log";
        return queryAllForList(Log.class, sql);
    }
}
