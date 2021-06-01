package com.HospitalManage.controller;

import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.StaffService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import static com.HospitalManage.controller.AlertController.errorAlert;


public class LoginController extends Stage {

    @FXML
    private TextField staffNumber;

    @FXML
    private PasswordField password;

    @FXML
    private Button submitBtn;

    private StaffService staffService;


    public LoginController() throws Exception {
        initialisation();
    }

    private void initialisation() throws Exception {
        GUIUtils.pageLoader(this,"Login","../view/login.fxml");
        staffService = new StaffService();
        setSubmit();
    }

    private void setSubmit(){
        submitBtn.setOnAction(actionEvent -> {
            try {
                inputValidation();
                Staff staff = staffService.getStaffById(Integer.parseInt(staffNumber.getText()));
                if(staff == null){
                    throw new Exception("Invalid StaffNumber");
                }
                if(!staff.getPassword().equals(password.getText())){
                    throw new Exception("Incorrect password");
                }
                System.out.println("Successfully login");
                close();
                new MainPageController(staff).show();

            }catch(NumberFormatException ne){
                errorAlert("Staff id is only in integer format");
            }catch (Exception e) {
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void inputValidation() throws Exception {
        if(staffNumber.getText().length()<=0 || staffNumber.getText() == null){
            throw new Exception("StaffNo cannot be empty");
        }
        if(password.getText().length()<=0 || password.getText() == null){
            throw new Exception("password cannot be empty");
        }
    }


}
