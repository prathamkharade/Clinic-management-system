package com.example.starttrial.controller;

import com.example.starttrial.entity.Patient;
import com.example.starttrial.repository.PatientRepository;
import com.example.starttrial.service.PatientService;
import com.example.starttrial.util.SpringFXMLLoader;
import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class SkeletonController implements Initializable {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @FXML
    private Button dashboardbtn, appointmentsbtn, logoutbtn, addpatientbtn, makeappointmentbtn, searchbtn;

    @FXML
    private AnchorPane controlpaneshow;

    @FXML
    private JFXDialog makeapptdialog, patdetdialog;

    @FXML
    private TextField searchbar;

    @FXML
    private StackPane stackpaneid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refresh();
    }

    private void loadDashboard() {
        try {
            FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/Page3-dashboard.fxml"));
            AnchorPane dashboard = loader.load();
            controlpaneshow.getChildren().setAll(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void logoutfunc(ActionEvent event) {
        try {
            FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/Page1-landing.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) logoutbtn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openapptsfunc(ActionEvent event) {
        try {
            FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/Page4-appointments.fxml"));
            AnchorPane appointments = loader.load();
            controlpaneshow.getChildren().setAll(appointments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void opendashboardfunc(ActionEvent event) {
        loadDashboard();
    }

    @FXML
    void addpatientfunc(ActionEvent event) {
        try {
            FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/dialog-patientdetails.fxml"));
            patdetdialog.setDialogContainer(stackpaneid);
            patdetdialog.setContent(loader.load());
            patdetdialog.show();

            PatDetDialogController controller1 = loader.getController();
            controller1.setPatdetdialog(patdetdialog);
            controller1.setSkeletonController(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void makeapptfunc(ActionEvent event) {
        try {
            FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/dialog-makeappt.fxml"));
            makeapptdialog.setDialogContainer(stackpaneid);
            makeapptdialog.setContent(loader.load());
            makeapptdialog.show();

            MakeApptDialogController controller = loader.getController();
            controller.setMakeAppointmentDialog(makeapptdialog);
            controller.setSkeletonController(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void searchfunc(ActionEvent event) {
        String searchText = searchbar.getText();
        String[] parts = searchText.split(" - ");
        String name = parts[0];
        String contact = parts.length > 1 ? parts[1] : "";
        Optional<Patient> patientOptional = patientRepository.findByNameOrContact(name, contact);

        patientOptional.ifPresent(patient -> {
            try {
                FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/dialog-patientdetails.fxml"));
                patdetdialog.setDialogContainer(stackpaneid);
                patdetdialog.setContent(loader.load());
                patdetdialog.show();
                PatDetDialogController controller1 = loader.getController();
                controller1.setPatdetdialog(patdetdialog);
                controller1.setSkeletonController(this);
                controller1.setPatientDetails(patient);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void refresh() {
        loadDashboard();
        List<String> patientNamesAndContacts = patientService.getPatientNamesAndContacts();
        TextFields.bindAutoCompletion(searchbar, patientNamesAndContacts);
    }
}
