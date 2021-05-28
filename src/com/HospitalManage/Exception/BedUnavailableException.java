package com.HospitalManage.Exception;

public class BedUnavailableException extends RuntimeException{
    public BedUnavailableException(String message) {
        super(message);
    }
}
