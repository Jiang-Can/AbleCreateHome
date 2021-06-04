package com.HospitalManage.controller;

import com.HospitalManage.service.LogService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ViewLogsController extends Stage {

    private LogService logService;

    @FXML
    private TextArea logsArea;

    public ViewLogsController(LogService logService) throws Exception {
        GUIUtils.pageLoader(this,"logs","../view/logs.fxml");
        this.logService = logService;
        logsArea.setText(logService.getAllLog());
    }



}
