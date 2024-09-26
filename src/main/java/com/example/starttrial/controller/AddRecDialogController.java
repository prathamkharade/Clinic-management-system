package com.example.starttrial.controller;

import com.calendarfx.view.TimeField;
import com.example.starttrial.entity.Patient;
import com.example.starttrial.entity.Record;
import com.example.starttrial.service.RecordService;
import com.jfoenix.controls.JFXDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddRecDialogController {

    @Autowired
    private RecordService recordService;

    private Patient patient;

    @FXML
    private Button addrecbtn;

    @FXML
    private DatePicker addrecordsdate;

    @FXML
    private TextField addrecordsdebit, addrecordsdues, addrecordsremarks, addrecordstetment, addrecordstoothno;

    @FXML
    private TimeField addrecordstime;

    @Setter
    private JFXDialog addrecdialog;

    @FXML
    void addrecfunc(ActionEvent event) {
        Record record = new Record();
        record.setPatient(patient);
        record.setAddrecordsdate(addrecordsdate.getValue());
        record.setAddrecordstime(addrecordstime.getValue());
        record.setAddrecordstoothno(addrecordstoothno.getText());
        record.setAddrecordstetment(addrecordstetment.getText());
        record.setAddrecordsdebit(addrecordsdebit.getText());
        record.setAddrecordsdues(addrecordsdues.getText());
        record.setAddrecordsremarks(addrecordsremarks.getText());

        if(addrecordsdate.getValue() != null && addrecordstime.getValue() != null && !addrecordstoothno.getText().isBlank() && !addrecordstetment.getText().isBlank() && !addrecordsdebit.getText().isBlank() && !addrecordsdues.getText().isBlank()) {
            recordService.saveRecord(record);
        }

        if (addrecdialog != null) {
            addrecdialog.close();
        }
    }

    public void getpetId (Patient patient) {
        this.patient = patient;
    }
}
