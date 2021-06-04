package com.HospitalManage.bean.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer logId;
    private Integer staffId;
    private LocalDateTime time;
    private String description;

    public Log(Integer staffId, String description) {
        this.staffId = staffId;
        this.description = description;
    }
}
