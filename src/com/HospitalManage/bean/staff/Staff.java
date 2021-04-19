package com.HospitalManage.bean.staff;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Staff {
    private Long id;
    private String name;
    private String password;
}
