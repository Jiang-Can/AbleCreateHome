package com.HospitalManage.service;

import com.HospitalManage.bean.misc.Log;
import com.HospitalManage.model.LogModel;

import java.time.LocalDateTime;
import java.util.List;

public class LogService {

    private LogModel logModel;

    public LogService(){
        logModel = new LogModel();
    }

    public void addNewLog(Log log){
        log.setTime(LocalDateTime.now());
        logModel.addNewLog(log);
    }

    public String getAllLog(){
        List<Log> logs = logModel.getAllLog();
        StringBuilder res = new StringBuilder();
        logs.forEach(log -> {
            res.append(log.getLogId()).append(" ").append("staff id:")
                    .append(log.getStaffId()).append(" action: ")
                    .append(log.getDescription()).append("\n");
        });
        return res.toString();
    }
}
