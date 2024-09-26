package com.example.starttrial.controller;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.DetailedDayView;
import com.example.starttrial.entity.Appointment;
import com.example.starttrial.entity.Patient;
import com.example.starttrial.service.AppointmentService;
import com.example.starttrial.service.PatientService;
import com.example.starttrial.util.SpringFXMLLoader;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class DashboardController implements Initializable {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @FXML
    private DetailedDayView detaileddayappt;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @FXML
    private VBox patientinfolayout;

    @FXML
    private Label patientstoday;

    @FXML
    private Label totalpatients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        totalpatients.setText(String.valueOf(patientService.countTotalPatients()));

        List<Appointment> todayAppointments = appointmentService.findAppointmentsForToday();
        long uniquePatientCount = todayAppointments.stream()
                .map(appointment -> appointment.getPatient().getPatientId())
                .distinct()
                .count();
        patientstoday.setText(String.valueOf(uniquePatientCount));

        List<Patient> patients = patientService.findAllPatientsOrderedByIdDesc();
//        int counter = 1;
        for (Patient patient : patients) {
            try {
                FXMLLoader loader = springFXMLLoader.load(getClass().getResource("/fxml/patientliststrip.fxml"));
                HBox hbox = loader.load();

                PatListStripController controller = loader.getController();
                controller.setPatientDetails(patient);

                patientinfolayout.getChildren().add(hbox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        EventHandler<MouseEvent> handler = MouseEvent::consume;
        detaileddayappt.addEventFilter(MouseEvent.ANY, handler);
        detaileddayappt.setContextMenuCallback(param -> null);
        detaileddayappt.setEntryFactory(param -> null);

        Calendar calendar = new Calendar("Appointments");
        calendar.setStyle(Calendar.Style.STYLE1);
        CalendarSource calendarSource = new CalendarSource("My Calendar Source");
        calendarSource.getCalendars().add(calendar);
        detaileddayappt.getCalendarSources().add(calendarSource); // This should add your calendar to the view
        Calendar firstCalendar = detaileddayappt.getCalendars().get(0);
        todayAppointments.forEach(appointment -> displayAppointmentInCalendar(appointment, firstCalendar));
    }

    private LocalTime calculateEndTime(LocalTime startTime, String duration) {
        switch (duration) {
            case "1/2 hour":
                return startTime.plusMinutes(30);
            case "1 hour":
                return startTime.plusHours(1);
            case "1 and 1/2 hour":
                return startTime.plusHours(1).plusMinutes(30);
            case "2 hour":
                return startTime.plusHours(2); 
            default:
                throw new IllegalArgumentException("Unknown duration: " + duration);
        }
    }

    private void displayAppointmentInCalendar(Appointment appointment, Calendar calendar) {
        LocalTime endTime = calculateEndTime(appointment.getApptdiagtime(), appointment.getApptdiagduration());

        Entry<String> entry = new Entry<>(appointment.getPatient().getPatientdetname() + "\n" + appointment.getApptdiagtreatment());
        entry.setInterval(LocalDate.now(), appointment.getApptdiagtime(), LocalDate.now(), endTime);

        calendar.addEntry(entry);
    }

}
