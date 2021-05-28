package com.HospitalManage.controller;

import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.service.WardService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import static com.HospitalManage.controller.AlertController.*;
public class AddNewPatientController extends Stage {

    private WardService wardService;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ToggleGroup isolation;

    @FXML
    private TextField name;

    @FXML
    private TextField bedNo;

    @FXML
    private Button addBtn;

    private final MainPageController mainPageController;

    public AddNewPatientController(WardService wardService, MainPageController mainPageController) throws Exception {
        this.wardService = wardService;
        this.mainPageController = mainPageController;
        GUIUtils.pageLoader(this,"add new patient","../view/add_new_patient.fxml");
        setAddBtn();
    }

    private void setAddBtn(){
        addBtn.setOnAction(actionEvent -> {
            try {
                Patient tempPatient = validateAndExtractInput();
                wardService.addPatientToTheBed(tempPatient);
                mainPageController.setNewPatient(tempPatient);
                close();
            }catch (Exception e){
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private Patient validateAndExtractInput() throws Exception {
        if(name.getText().length()<=0||name.getText() == null){
            throw new Exception("Must enter the name");
        }
        if(bedNo.getText().length()<=0||bedNo.getText() == null){
            throw new Exception("Must enter the bedNo");
        }
        if(gender.getSelectedToggle() == null){
            throw new Exception("Must select the gender");
        }

        if(isolation.getSelectedToggle() == null){
            throw new Exception("Must select the isolation");
        }
        return new Patient(name.getText(),
                ((ToggleButton)gender.getSelectedToggle()).getText(),
                "TRUE".equals(((ToggleButton) isolation.getSelectedToggle()).getText()),
                bedNo.getText());
    }

}
