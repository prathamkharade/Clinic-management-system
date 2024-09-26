package com.example.starttrial.controller;

import com.example.starttrial.entity.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class DentalTetStripController {

    @FXML
    private Label dentaltreatmentdate;

    @FXML
    private Label dentaltreatmentdebit;

    @FXML
    private Label dentaltreatmentdues;

    @FXML
    private Label dentaltreatmentremarks;

    @FXML
    private Label dentaltreatmenttetment;

    @FXML
    private Label dentaltreatmenttime;

    @FXML
    private Label dentaltreatmenttoothno;

    @FXML
    private HBox dentethbox;

    public void setRecordDetails(Record record) {
        dentaltreatmentdate.setText(record.getAddrecordsdate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dentaltreatmenttime.setText(record.getAddrecordstime().format(DateTimeFormatter.ofPattern("HH:mm")));
        dentaltreatmenttoothno.setText(record.getAddrecordstoothno());
        dentaltreatmenttetment.setText(record.getAddrecordstetment());
        dentaltreatmentdebit.setText(record.getAddrecordsdebit());
        dentaltreatmentdues.setText(record.getAddrecordsdues());
        dentaltreatmentremarks.setText(record.getAddrecordsremarks());
    }

}
