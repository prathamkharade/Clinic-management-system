package com.example.starttrial.controller;

import com.calendarfx.view.TimeField;
import com.example.starttrial.entity.Appointment;
import com.example.starttrial.entity.Patient;
import com.example.starttrial.repository.PatientRepository;
import com.example.starttrial.service.AppointmentService;
import com.example.starttrial.service.PatientService;
import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.Setter;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class MakeApptDialogController implements Initializable {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Setter
    private SkeletonController skeletonController;

    @FXML
    private DatePicker apptdiagdate;

    @FXML
    private ChoiceBox<String> apptdiagduration;
    private String[] durations = {"1/2 hour", "1 hour", "1 and 1/2 hour", "2 hour"};

    @FXML
    private TextField apptdiagnotes, apptdiagpatient, apptdiagtreatment;

    @FXML
    private TimeField apptdiagtime;

    @FXML
    private Button makeapptbtn;

    @FXML
    private Label errorlabel;

    @Setter
    private JFXDialog makeAppointmentDialog;

    @FXML
    void makeapptfunc(ActionEvent event) {
        String searchText = apptdiagpatient.getText();
        String[] parts = searchText.split(" - ");
        String name = parts[0];
        String contact = parts.length > 1 ? parts[1] : "";
        Optional<Patient> patientOptional = patientRepository.findByNameOrContact(name, contact);

        patientOptional.ifPresent(patient -> {
            if(apptdiagdate.getValue() != null && apptdiagtime.getValue() != null && apptdiagduration.getValue() != null &&  !apptdiagtreatment.getText().isBlank()) {
                Appointment appointment = new Appointment();
                appointment.setPatient(patient);
                appointment.setApptdiagdate(apptdiagdate.getValue());
                appointment.setApptdiagtime(apptdiagtime.getValue());
                appointment.setApptdiagduration(apptdiagduration.getValue());
                appointment.setApptdiagtreatment(apptdiagtreatment.getText());
                appointment.setApptdiagnotes(apptdiagnotes.getText());
                appointmentService.saveAppointment(appointment);
            }
        });

        skeletonController.refresh();

        if (makeAppointmentDialog != null) {
            makeAppointmentDialog.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> patientNamesAndContacts = patientService.getPatientNamesAndContacts();
        TextFields.bindAutoCompletion(apptdiagpatient, patientNamesAndContacts);

        apptdiagduration.getItems().addAll(durations);
    }
}
