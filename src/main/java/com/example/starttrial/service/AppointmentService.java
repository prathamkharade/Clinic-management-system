package com.example.starttrial.service;

import com.example.starttrial.dto.AppointmentDto;
import com.example.starttrial.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);

    long countAppointmentsToday();

    List<Appointment> findAppointmentsForToday();

    List<Appointment> findAllAppointments();

}
