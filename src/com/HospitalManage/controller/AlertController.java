package com.HospitalManage.controller;

import javafx.scene.control.Alert;

public class AlertController {

    public static void errorAlert(String errMessage){
        new Alert(Alert.AlertType.ERROR,errMessage).showAndWait();
    }

    public static void infoAlert(String errMessage){
        new Alert(Alert.AlertType.INFORMATION,errMessage).showAndWait();
    }
}
