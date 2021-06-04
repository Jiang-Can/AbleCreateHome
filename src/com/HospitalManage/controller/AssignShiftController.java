package com.HospitalManage.controller;

import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.ShiftService;
import com.HospitalManage.service.StaffService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.HospitalManage.controller.AlertController.errorAlert;

public class AssignShiftController extends Stage {
    @FXML
    private Button s1_1,s1_2,s2_1,s2_2,s3_1,s3_2,s4_1,s4_2,s5_1,s5_2,s6_1,s6_2,s7_1,s7_2;

    private List<Button> shifts;

    private ShiftService shiftService;

    private StaffService staffService;

    public AssignShiftController(ShiftService shiftService, StaffService staffService) throws Exception {
        GUIUtils.pageLoader(this,"shift","../view/shift.fxml");
        this.shiftService = shiftService;
        this.staffService = staffService;
        setShifts();
        setShiftsButtons();
    }

    private void setShifts(){
        shifts = new ArrayList<>(Arrays.asList(s1_1,s1_2,s2_1,s2_2,s3_1,s3_2,s4_1,s4_2,s5_1,s5_2,s6_1,s6_2,s7_1,s7_2));
    }

    private void setShiftsButtons(){
        shifts.forEach(shift->{
            shift.setOnAction(actionEvent -> {
                try {
                    new ShiftForNurseController(shiftService,staffService,shift.getId()).showAndWait();
                }catch (Exception e){
                    errorAlert(e.getMessage());
                }
            });
        });
    }







}
