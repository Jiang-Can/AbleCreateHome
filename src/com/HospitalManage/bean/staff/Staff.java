package com.HospitalManage.bean.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Staff {
    private Integer id;
    private String name;
    private String password;
    private String job;

    public Staff(String name, String password, String job) {
        this.name = name;
        this.password = password;
        this.job = job;
    }
}