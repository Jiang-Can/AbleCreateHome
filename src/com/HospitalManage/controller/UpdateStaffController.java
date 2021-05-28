package com.HospitalManage.controller;

import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.StaffService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.HospitalManage.controller.AlertController.errorAlert;
import static com.HospitalManage.controller.AlertController.infoAlert;

public class UpdateStaffController extends Stage {

    private StaffService staffService;

    @FXML
    private TextField staffId,name;

    @FXML
    private PasswordField password,confirmPwd;

    @FXML
    private ToggleGroup job;

    @FXML
    private Button updateBtn;

    public UpdateStaffController(StaffService staffService) throws Exception {
        this.staffService = staffService;
        GUIUtils.pageLoader(this,"update staff","../view/update_staff.fxml");
        setUpdateBtn();
    }

    private void setUpdateBtn(){
        updateBtn.setOnAction(actionEvent -> {
            try {
                staffService.updateStaff(validateAndExtractInput());
                infoAlert("Update successfully");
                close();
            }catch (NumberFormatException ne){
                errorAlert("Staff id is only in integer format");
            } catch (Exception e){
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }
    private Staff validateAndExtractInput() throws Exception {
        if(staffId.getText().length()<=0||staffId.getText() == null){
            throw new Exception("Must enter the id");
        }
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
        return new Staff(Integer.parseInt(staffId.getText()),
                name.getText(),
                password.getText(),
                ((ToggleButton)job.getSelectedToggle()).getText());
    }
}
