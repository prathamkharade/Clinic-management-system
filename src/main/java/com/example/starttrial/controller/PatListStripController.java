package com.example.starttrial.controller;

import com.example.starttrial.entity.Patient;
import com.example.starttrial.service.PatientService;
import com.example.starttrial.util.SpringFXMLLoader;
import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Component
public class PatListStripController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatDetDialogController patDetDialogController;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @FXML
    private Label patientlistage;

    @FXML
    private Label patientlistcontact;

    @FXML
    private Label patientlistname;

    @FXML
    private Label patientlistno;

    @FXML
    private HBox patlisthbox;

    public void setPatientDetails(Patient patient) {
        patientlistno.setText(String.valueOf(patient.getPatientId()));
        patientlistname.setText(patient.getPatientdetname());
        patientlistcontact.setText(patient.getPatientdetcontact());

        LocalDate birthDate = patient.getPatientdetbirthdate();
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();

        patientlistage.setText(String.valueOf(age));
    }

}
