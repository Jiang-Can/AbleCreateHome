package com.HospitalManage.controller;

import com.HospitalManage.utils.GUIUtils;
import javafx.stage.Stage;

public class TestController extends Stage {
    public TestController(String s) throws Exception {
        GUIUtils.pageLoader(this,"test", "../view/test.fxml");
        System.out.println(s);
    }
}
