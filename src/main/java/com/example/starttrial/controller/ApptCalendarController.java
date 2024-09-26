package com.example.starttrial.controller;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import com.example.starttrial.entity.Appointment;
import com.example.starttrial.entity.Patient;
import com.example.starttrial.service.AppointmentService;
import com.example.starttrial.service.PatientService;
import com.example.starttrial.util.SpringFXMLLoader;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ApptCalendarController implements Initializable {

    @FXML
    private CalendarView apptcalendar;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        EventHandler<MouseEvent> handler = MouseEvent::consume;
//        apptcalendar.addEventFilter(MouseEvent.ANY, handler);
        apptcalendar.setContextMenuCallback(param -> null);
        apptcalendar.setEntryFactory(param -> null);

        Calendar calendar = new Calendar("Appointments");
        calendar.setStyle(Calendar.Style.STYLE1);

        CalendarSource calendarSource = new CalendarSource("My Calendar Source");
        calendarSource.getCalendars().add(calendar);

        apptcalendar.getCalendarSources().clear();
        apptcalendar.getCalendarSources().add(calendarSource);

        List<Appointment> appointments = appointmentService.findAllAppointments();
        appointments.forEach(appointment -> displayAppointmentInCalendar(appointment, calendar));
    }

    private void displayAppointmentInCalendar(Appointment appointment, Calendar calendar) {
        LocalTime endTime = calculateEndTime(appointment.getApptdiagtime(), appointment.getApptdiagduration());

        Entry<String> entry = new Entry<>(appointment.getPatient().getPatientdetname() + "\n" + appointment.getApptdiagtreatment());
        entry.setInterval(appointment.getApptdiagdate(), appointment.getApptdiagtime(), appointment.getApptdiagdate(), endTime);

        calendar.addEntry(entry);
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

}
