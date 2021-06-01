package com.HospitalManage.controller;

import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Job;
import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.WardService;
import com.HospitalManage.utils.GUIUtils;
import com.HospitalManage.utils.ValidationUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.HospitalManage.controller.AlertController.errorAlert;
import static com.HospitalManage.controller.AlertController.infoAlert;
import static com.HospitalManage.utils.ValidationUtils.jobValidation;

public class PatientDetailsController extends Stage {

    @FXML
    private Label id,name,isolation;

    @FXML
    private TextField bedNo;

    @FXML
    private Button changeBed,addPrescription;

    private MainPageController mainPageController;

    private WardService wardService;

    private Patient patient;

    private Staff loginStaff;

    public PatientDetailsController(MainPageController mainPageController,String bedNo,Staff loginStaff) throws Exception {
        this.mainPageController = mainPageController;
        this.wardService = mainPageController.getWardService();
        this.loginStaff = loginStaff;
        patient = wardService.getPatientMap().get(bedNo);
        GUIUtils.pageLoader(this,"check patient details","../view/patient_details.fxml");
        initializeDisplay();
        setChangeBed();
        setAddPrescription();
    }

    private void setChangeBed(){
        changeBed.setOnAction(actionEvent -> {
            try {
                jobValidation(loginStaff.getJob(),Job.NURSE);
                String originBedNo = patient.getBedNo();
                //bedNo unChange validation
                if(bedNo.getText().equals(patient.getBedNo())){
                    throw new Exception("Please enter a new bedNo");
                }
                wardService.movePatientToTargetBed(patient,bedNo.getText());
                mainPageController.resetTheColor(originBedNo);
                mainPageController.renderSingleBed(bedNo.getText(),patient.getGender());
                infoAlert("Change bed success");
            }catch (Exception e){
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void setAddPrescription(){
        addPrescription.setOnAction(actionEvent -> {
            try {
                jobValidation(loginStaff.getJob(),Job.DOCTOR);
                new AddNewPrescriptionController(
                        wardService,
                        loginStaff.getId(),
                        patient.getPatientId()).showAndWait();
            } catch (Exception e) {
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void initializeDisplay(){
        id.setText(patient.getPatientId()+"");
        name.setText(patient.getName());
        isolation.setText(patient.getIsolation().toString());
        bedNo.setText(patient.getBedNo());
    }

}
