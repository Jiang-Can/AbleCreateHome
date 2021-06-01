package com.HospitalManage;

import com.HospitalManage.controller.LoginController;
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
        new LoginController().show();
    }


}
