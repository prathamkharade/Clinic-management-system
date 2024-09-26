package com.example.starttrial.controller;

import com.example.starttrial.entity.Patient;
import com.example.starttrial.entity.Record;
import com.example.starttrial.service.PatientService;
import com.example.starttrial.util.SpringFXMLLoader;
import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class PatDetDialogController implements Initializable {

    @Autowired
    private PatientService patientService;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @Autowired
    private AddRecDialogController addRecDialogController;

    @Setter
    private SkeletonController skeletonController;

    private Patient patient;

    @FXML
    private JFXDialog addrecdialog;

    @FXML
    private Button addrecordbtn, insertbtn, updatebtn;

    @FXML
    private ToggleGroup treatmenthistory;

    @FXML
    private RadioButton notreatmentbefore, yestreatmentbefore;

    @FXML
    private StackPane stackpatdet;

    @FXML
    private TextArea patientdetaddress, patientdetadvice;

    @FXML
    private TextField patientdetallergy, patientdetbloodgrp, patientdetcontact, patientdetemail, patientdetmedication, patientdetname;

    @FXML
    private DatePicker patientdetbirthdate, patientdetregisdate;

    @FXML
    private CheckBox patientdetchk1, patientdetchk2, patientdetchk3, patientdetchk4, patientdetchk5, patientdetchk6, patientdetchk7, patientdetchk8, patientdetchk9, patientdetchk10, patientdetchk11, patientdetchk12, patientdetchk13, patientdetchk14;

    @FXML
    private VBox treatmentinfolayout;

    @FXML
    private AnchorPane dettetanchorpane;

    @Setter
    private JFXDialog patdetdialog;

    @FXML
    void addrecordfunc(ActionEvent event) {
        showDialog(addrecdialog, "/fxml/dialog-addrecord.fxml");
        addRecDialogController.getpetId(this.patient);
        addRecDialogController.setAddrecdialog(addrecdialog);
    }

    @FXML
    void insertdetailsfunc(ActionEvent event) {
        Patient newpatient = new Patient();
        newpatient.setPatientdetname(patientdetname.getText());
        newpatient.setPatientdetcontact(patientdetcontact.getText());
        newpatient.setPatientdetbloodgrp(patientdetbloodgrp.getText());
        newpatient.setPatientdetemail(patientdetemail.getText());
        newpatient.setPatientdetaddress(patientdetaddress.getText());
        newpatient.setPatientdetmedication(patientdetmedication.getText());
        newpatient.setPatientdetallergy(patientdetallergy.getText());
        newpatient.setPatientdetadvice(patientdetadvice.getText());
        newpatient.setPatientdetbirthdate(patientdetbirthdate.getValue());
        newpatient.setPatientdetregisdate(patientdetregisdate.getValue());
        newpatient.setPatientdetchk1(patientdetchk1.isSelected());
        newpatient.setPatientdetchk2(patientdetchk2.isSelected());
        newpatient.setPatientdetchk3(patientdetchk3.isSelected());
        newpatient.setPatientdetchk4(patientdetchk4.isSelected());
        newpatient.setPatientdetchk5(patientdetchk5.isSelected());
        newpatient.setPatientdetchk6(patientdetchk6.isSelected());
        newpatient.setPatientdetchk7(patientdetchk7.isSelected());
        newpatient.setPatientdetchk8(patientdetchk8.isSelected());
        newpatient.setPatientdetchk9(patientdetchk9.isSelected());
        newpatient.setPatientdetchk10(patientdetchk10.isSelected());
        newpatient.setPatientdetchk11(patientdetchk11.isSelected());
        newpatient.setPatientdetchk12(patientdetchk12.isSelected());
        newpatient.setPatientdetchk13(patientdetchk13.isSelected());
        newpatient.setPatientdetchk14(patientdetchk14.isSelected());
        newpatient.setTreatmenthistory(yestreatmentbefore.isSelected());

        if (!newpatient.getPatientdetname().isBlank() && !newpatient.getPatientdetcontact().isBlank()) {
            patientService.savePatient(newpatient);
        }

        skeletonController.refresh();

        if (patdetdialog != null) {
            patdetdialog.close();
        }
    }

    @FXML
    void updatedetailsfunc(ActionEvent event) {
        if (this.patient != null) {
            this.patient.setPatientdetname(patientdetname.getText());
            this.patient.setPatientdetcontact(patientdetcontact.getText());
            this.patient.setPatientdetbloodgrp(patientdetbloodgrp.getText());
            this.patient.setPatientdetemail(patientdetemail.getText());
            this.patient.setPatientdetaddress(patientdetaddress.getText());
            this.patient.setPatientdetmedication(patientdetmedication.getText());
            this.patient.setPatientdetallergy(patientdetallergy.getText());
            this.patient.setPatientdetadvice(patientdetadvice.getText());
            this.patient.setPatientdetbirthdate(patientdetbirthdate.getValue());
            this.patient.setPatientdetregisdate(patientdetregisdate.getValue());
            this.patient.setPatientdetchk1(patientdetchk1.isSelected());
            this.patient.setPatientdetchk2(patientdetchk2.isSelected());
            this.patient.setPatientdetchk3(patientdetchk3.isSelected());
            this.patient.setPatientdetchk4(patientdetchk4.isSelected());
            this.patient.setPatientdetchk5(patientdetchk5.isSelected());
            this.patient.setPatientdetchk6(patientdetchk6.isSelected());
            this.patient.setPatientdetchk7(patientdetchk7.isSelected());
            this.patient.setPatientdetchk8(patientdetchk8.isSelected());
            this.patient.setPatientdetchk9(patientdetchk9.isSelected());
            this.patient.setPatientdetchk10(patientdetchk10.isSelected());
            this.patient.setPatientdetchk11(patientdetchk11.isSelected());
            this.patient.setPatientdetchk12(patientdetchk12.isSelected());
            this.patient.setPatientdetchk13(patientdetchk13.isSelected());
            this.patient.setPatientdetchk14(patientdetchk14.isSelected());
            this.patient.setTreatmenthistory(yestreatmentbefore.isSelected());

            if (!this.patient.getPatientdetname().isBlank() && !this.patient.getPatientdetcontact().isBlank()) {
                patientService.savePatient(this.patient);
            }
        }

        skeletonController.refresh();

        if (patdetdialog != null) {
            patdetdialog.close();
        }
    }

    private void showDialog(JFXDialog dialog, String fxmlPath) {
        try {
            FXMLLoader loader = springFXMLLoader.load(getClass().getResource(fxmlPath));
            dialog.setDialogContainer(stackpatdet);
            dialog.setContent(loader.load());
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dettetanchorpane.setVisible(false);
        insertbtn.setVisible(true);
    }

    public void setPatientDetails(Patient patient) {
        if (patient != null) {
            this.patient = patient;
            patientdetname.setText(patient.getPatientdetname());
            patientdetcontact.setText(patient.getPatientdetcontact());
            patientdetbloodgrp.setText(patient.getPatientdetbloodgrp());
            patientdetemail.setText(patient.getPatientdetemail());
            patientdetaddress.setText(patient.getPatientdetaddress());
            patientdetmedication.setText(patient.getPatientdetmedication());
            patientdetallergy.setText(patient.getPatientdetallergy());
            patientdetadvice.setText(patient.getPatientdetadvice());
            patientdetbirthdate.setValue(patient.getPatientdetbirthdate());
            patientdetregisdate.setValue(patient.getPatientdetregisdate());
            patientdetchk1.setSelected(patient.getPatientdetchk1());
            patientdetchk2.setSelected(patient.getPatientdetchk2());
            patientdetchk3.setSelected(patient.getPatientdetchk3());
            patientdetchk4.setSelected(patient.getPatientdetchk4());
            patientdetchk5.setSelected(patient.getPatientdetchk5());
            patientdetchk6.setSelected(patient.getPatientdetchk6());
            patientdetchk7.setSelected(patient.getPatientdetchk7());
            patientdetchk8.setSelected(patient.getPatientdetchk8());
            patientdetchk9.setSelected(patient.getPatientdetchk9());
            patientdetchk10.setSelected(patient.getPatientdetchk10());
            patientdetchk11.setSelected(patient.getPatientdetchk11());
            patientdetchk12.setSelected(patient.getPatientdetchk12());
            patientdetchk13.setSelected(patient.getPatientdetchk13());
            patientdetchk14.setSelected(patient.getPatientdetchk14());
            if (Boolean.TRUE.equals(patient.getTreatmenthistory())) {
                yestreatmentbefore.setSelected(true);
            } else {
                notreatmentbefore.setSelected(true);
            }

            List<Record> records = patientService.findRecordsByPatient(patient);
            treatmentinfolayout.getChildren().clear();
            for (Record record : records) {
                try {
                    FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/dentaltreatmentstrip.fxml"));
                    HBox hbox = loader.load();
                    DentalTetStripController controller = loader.getController();
                    controller.setRecordDetails(record);
                    treatmentinfolayout.getChildren().add(hbox);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            dettetanchorpane.setVisible(true);
            insertbtn.setVisible(false);
        }
    }

    public void refresh(Patient patient) {
        List<Record> records = patientService.findRecordsByPatient(patient);
        treatmentinfolayout.getChildren().clear();
        for (Record record : records) {
            try {
                FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/dentaltreatmentstrip.fxml"));
                HBox hbox = loader.load();
                DentalTetStripController controller = loader.getController();
                controller.setRecordDetails(record);
                treatmentinfolayout.getChildren().add(hbox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
