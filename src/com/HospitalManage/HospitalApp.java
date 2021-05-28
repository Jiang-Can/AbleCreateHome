package com.HospitalManage;

import com.HospitalManage.controller.Login;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HospitalApp extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
/*        Parent parent = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        stage.setTitle("login");
        stage.setScene(new Scene(parent));
        stage.show();*/
        new Login().show();
    }


}
