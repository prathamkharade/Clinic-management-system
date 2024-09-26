package com.example.starttrial.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.starttrial.service.DoctorService;
import com.example.starttrial.util.SpringFXMLLoader; // Import the SpringFXMLLoader

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class DoctorController implements Initializable {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SpringFXMLLoader springFXMLLoader; // Inject SpringFXMLLoader

    @FXML
    private Button btn;

    @FXML
    private JFXDialog dialog;

    @FXML
    private TextField id;

    @FXML
    private JFXButton okbutton;

    @FXML
    private PasswordField password;

    @FXML
    private StackPane root;

    @FXML
    private Label status;

    @FXML
    void showDialog(ActionEvent event) {
        if (doctorService.validateLogin(id.getText(), password.getText())) {
            status.setText("Login Successful!!!");
            dialog.show();
            okbutton.setOnAction(e -> {
                dialog.close();
                navigateToDashboard();
            });
        } else {
            status.setText("Login Unsuccessful! Try Again");
            dialog.show();
            okbutton.setOnAction(e -> {
                dialog.close();
                id.setText("");
                password.setText("");
            });
        }
    }

    private void navigateToDashboard() {
        try {
            // Use SpringFXMLLoader to load the dashboard
            FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/Page2-skeleton.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dialog.setDialogContainer(root);
    }
}
