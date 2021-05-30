package com.HospitalManage.controller;

import com.HospitalManage.bean.patient.Patient;
import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.StaffService;
import com.HospitalManage.service.WardService;
import com.HospitalManage.utils.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

import static com.HospitalManage.controller.AlertController.*;
import static com.HospitalManage.utils.ValidationUtils.*;


public class MainPageController extends Stage {

    private final String defaultColor = "-fx-border-color: #000;-fx-background-color: #fff";

    // color style for female bed
    private final String red = "-fx-border-color: #000;-fx-background-color: red";

    // color style for male bed
    private final String blue = "-fx-border-color: #000;-fx-background-color: blue";

    private Staff loginStaff;

    private WardService wardService;

    private StaffService staffService;

    private List<Button> beds;

    private Map<String,Button> bedMap;

    @FXML
    private Button b1_1_1,b1_2_2,b1_2_1,b1_3_1,b1_3_2,b1_3_3,b1_3_4,
            b1_4_1,b1_4_2,b1_4_3,b1_4_4,b1_5_1,b1_5_2,b1_5_3,b1_5_4,
            b1_6_1,b1_6_2,b1_6_3,b1_6_4,b2_1_1,b2_2_2,b2_2_1,b2_3_1,
            b2_3_2,b2_3_3,b2_3_4,b2_4_1,b2_4_2,b2_4_3,b2_4_4,b2_5_1,
            b2_5_2,b2_5_3,b2_5_4,b2_6_1,b2_6_2,b2_6_3,b2_6_4;

    @FXML
    private Button checkDetails;

    @FXML
    private Text bedNoDisplay,patientName;

    @FXML
    private MenuItem addNewPatient,addNewStaff,updateStaff;

    //This is for the AddNewController to pass the patient which has been successfully created
    private Patient newPatient;

    public MainPageController(Staff staff) throws Exception {
        initialisation();
        loginStaff = staff;
        System.out.println(staff.getName());

    }
    private void initialisation() throws Exception {
        GUIUtils.pageLoader(this,"main page","../view/main_page.fxml");
        wardService = new WardService();
        staffService = new StaffService();
        bedMap = new HashMap<>();
        setBedList();
        setEachBedBtn();
        setAddNewPatient();
        setAddNewStaff();
        setUpdateStaff();
        renderBedsColor();

    }

    private void setEachBedBtn(){
        for(Button bed:beds){
            bed.setOnAction(actionEvent -> {
                bedNoDisplay.setText(bed.getId().substring(1));
                Patient show = wardService.getPatientMap()
                        .get(bed.getId().substring(1));
                if(show!=null){
                    patientName.setText(show.getName());
                }else{
                    patientName.setText("No patient in this bed");
                }
            });
            bedMap.put(bed.getId().substring(1),bed);
        }
    }
    private void setBedList(){
        beds = new ArrayList(Arrays.asList(b1_1_1, b1_2_1, b1_2_2,
                b1_3_1, b1_3_2, b1_3_3, b1_3_4, b1_4_1, b1_4_2, b1_4_3, b1_4_4,
                b1_5_1, b1_5_2, b1_5_3, b1_5_4, b1_6_1, b1_6_2, b1_6_3, b1_6_4,
                b2_1_1, b2_2_1,b2_2_2, b2_3_1, b2_3_2, b2_3_3, b2_3_4, b2_4_1,
                b2_4_2, b2_4_3, b2_4_4, b2_5_1, b2_5_2, b2_5_3, b2_5_4, b2_6_1,
                b2_6_2, b2_6_3, b2_6_4));
    }
    private void renderBedsColor(){
        for(Map.Entry<String,Patient> entry:wardService.getPatientMap().entrySet()){
            bedMap.get(entry.getKey())
                    .setStyle("MALE".equals(entry.getValue().getGender())?blue:red);
        }
    }

    //Start add new patient segment
    private void setAddNewPatient(){
        addNewPatient.setOnAction(actionEvent -> {
            try {
                managerValidation(loginStaff.getJob());
                new AddNewPatientController(wardService,this).showAndWait();
                if(newPatient !=null){
                    System.out.println(newPatient.getName());
                    renderSingleBed(newPatient);
                    newPatient = null;
                }

            } catch (Exception e){
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void renderSingleBed(Patient patient){
        bedMap.get(patient.getBedNo())
                .setStyle("MALE".equals(patient.getGender())?blue:red);
    }

    public void setNewPatient(Patient newPatient){
        this.newPatient = newPatient;
    }
    //End add new patient segment

    //Start add new staff segment
    private void setAddNewStaff(){
        addNewStaff.setOnAction(actionEvent -> {
            try {
                managerValidation(loginStaff.getJob());
                new AddNewStaffController(staffService).show();
            } catch (Exception e) {
                errorAlert(e.getMessage());
                e.printStackTrace();
            }
        });
    }
    //End add new staff segment

    //Start update staff
    private void setUpdateStaff(){
        updateStaff.setOnAction(actionEvent -> {
            try {
                managerValidation(loginStaff.getJob());
                new UpdateStaffController(staffService).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    //End update staff

    public void setCheckDetails(){

    }
}
