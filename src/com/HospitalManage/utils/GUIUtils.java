package com.HospitalManage.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIUtils {

    public static void pageLoader(Stage stage,String title, String viewPath) throws Exception {
        stage.setTitle(title);
        FXMLLoader fxld = new FXMLLoader(stage.getClass().getResource(viewPath));
        fxld.setController(stage);
        stage.setScene(new Scene(fxld.load()));
    }
}
