package com.HospitalManage.controller;

import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.model.StaffModel;
import com.HospitalManage.service.StaffService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.HospitalManage.controller.AlertController.errorAlert;
import static com.HospitalManage.controller.AlertController.infoAlert;

public class AddNewStaffController extends Stage {

    private StaffService staffService;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password,confirmPwd;

    @FXML
    private ToggleGroup job;

    @FXML
    private Button addBtn;

    public AddNewStaffController(StaffService staffService) throws Exception {
        this.staffService = staffService;
        GUIUtils.pageLoader(this,"add new staff","../view/add_new_staff.fxml");
        setAddBtn();
    }

    private void setAddBtn(){
        addBtn.setOnAction(actionEvent -> {
            try {
                int id = staffService.addNewStaff(validateAndExtractInput());
                infoAlert("New staff has been successfully created, your staff id is: "+id);
                close();
            }catch (Exception e){
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }
    private Staff validateAndExtractInput() throws Exception {
        if(name.getText().length()<=0||name.getText() == null){
            throw new Exception("Must enter the name");
        }
        if(password.getText().length()<=0||password.getText() == null){
            throw new Exception("Must enter the password");
        }
        if(confirmPwd.getText().length()<=0||confirmPwd.getText() == null){
            throw new Exception("Must confirm the password");
        }
        if(!password.getText().equals(confirmPwd.getText())){
            throw new Exception("Passwords are not match");
        }
        if(job.getSelectedToggle() == null){
            throw new Exception("Must select the job type");
        }
        return new Staff(name.getText(),
                password.getText(),
                ((ToggleButton)job.getSelectedToggle()).getText());
    }
}
