package com.HospitalManage.controller;

import com.HospitalManage.bean.misc.Prescription;
import com.HospitalManage.service.WardService;
import com.HospitalManage.utils.DateTimeUtils;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.format.DateTimeParseException;

import static com.HospitalManage.controller.AlertController.errorAlert;
import static com.HospitalManage.utils.DateTimeUtils.parseToLocalTime;


public class AddNewPrescriptionController extends Stage {

    @FXML
    private Label doctorId,patientId;

    @FXML
    private TextField medicine,doses,time;

    @FXML
    private Button addBtn;

    private WardService wardService;

    private Integer pId,dId;

    public AddNewPrescriptionController(WardService wardService,Integer doctorId, Integer patientId) throws Exception {
        GUIUtils.pageLoader(this,"add new prescription","../view/add_new_prescription.fxml");
        this.doctorId.setText(doctorId+"");
        this.patientId.setText(patientId+"");
        this.wardService = wardService;
        pId = patientId;
        dId = doctorId;
        setAddBtn();
    }

    private void setAddBtn(){
        addBtn.setOnAction(actionEvent -> {
            try {
                wardService.addNewPrescription(validateAndExtractInput());
                close();
            }catch (NumberFormatException ne){
                errorAlert("please input correct doses");
            }catch (DateTimeParseException de){
                errorAlert("please input the time in correct format");
            }catch (Exception e){
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private Prescription validateAndExtractInput() throws Exception {
        Prescription prescription = new Prescription();
        prescription.setDoctorId(dId);
        prescription.setPatientId(pId);
        if(medicine.getText().length()<=0){
            throw new Exception("please input medicine name");
        }
        prescription.setMedicine(medicine.getText());
        prescription.setDoses(Double.parseDouble(doses.getText()));
        prescription.setTime(parseToLocalTime(time.getText()));
        return prescription;
    }

}
