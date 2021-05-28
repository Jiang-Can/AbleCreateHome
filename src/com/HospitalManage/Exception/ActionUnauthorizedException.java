package com.HospitalManage.Exception;

public class ActionUnauthorizedException extends RuntimeException{
    public ActionUnauthorizedException(String message) {
        super(message);
    }
}
