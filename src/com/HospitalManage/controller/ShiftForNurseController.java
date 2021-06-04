package com.HospitalManage.controller;

import com.HospitalManage.bean.misc.NurseShift;
import com.HospitalManage.bean.staff.Job;
import com.HospitalManage.service.ShiftService;
import com.HospitalManage.service.StaffService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import static com.HospitalManage.controller.AlertController.errorAlert;
import static com.HospitalManage.controller.AlertController.infoAlert;

public class ShiftForNurseController extends Stage {

    @FXML
    private TextField id;

    @FXML
    private Label workTime;

    @FXML
    private Button addBtn;

    @FXML
    private TextArea details;

    private ShiftService shiftService;

    private StaffService staffService;

    private String shiftCode;

    private Map<Character,String> dayMap;

    public ShiftForNurseController(ShiftService shiftService,StaffService staffService,String shiftCode) throws Exception {
        GUIUtils.pageLoader(this,"shift nurse","../view/shift_nurse.fxml");
        this.staffService = staffService;
        this.shiftService = shiftService;
        this.shiftCode = shiftCode;
        setDetails();
        setAddBtn();
        setDayMap();
        setWorkTime();
    }

    private void setAddBtn(){
        addBtn.setOnAction(actionEvent -> {
            try {
                if(!staffService.getStaffMap().containsKey(Integer.parseInt(id.getText()))){
                    throw new Exception("please enter valid staff id");
                }
                if(!staffService.getStaffMap().get(Integer.parseInt(id.getText())).getJob()
                .equals(Job.NURSE.toString())){
                    throw new Exception("This staff id is not of a nurse");
                }
                Integer day = Integer.parseInt(String.valueOf(shiftCode.charAt(1)));
                NurseShift nurseShift = new NurseShift(shiftCode,day,Integer.parseInt(id.getText()));
                shiftService.addNurseShift(nurseShift);
                infoAlert("add success");
                close();
            }catch (NumberFormatException nf){
                errorAlert("please enter valid staff id");
            }catch (Exception e){
                errorAlert(e.getMessage());
            }

        });
    }

    private void setDetails(){
        details.setText(shiftService.getNurseShiftDetailsByShiftCode(shiftCode));
    }

    private void setDayMap(){
        dayMap = new HashMap<>();
        dayMap.put('1',"Mon");dayMap.put('2',"Tue");dayMap.put('3',"Wed");dayMap.put('4',"Thu");
        dayMap.put('5',"Fri");dayMap.put('6',"Sat");dayMap.put('7',"Sun");
    }
    private void setWorkTime(){
        String half = shiftCode.charAt(3)=='1'?"8am to 4pm":"2pm to 10pm";
        workTime.setText(dayMap.get(shiftCode.charAt(1))+" "+half);
    }
}
