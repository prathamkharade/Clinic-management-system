package com.example.starttrial.serviceImpl;

import com.example.starttrial.entity.Appointment;
import com.example.starttrial.repository.AppointmentRepository;
import com.example.starttrial.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public long countAppointmentsToday() {
        LocalDate today = LocalDate.now();
        return appointmentRepository.countByApptdiagdate(today);
    }

    public List<Appointment> findAppointmentsForToday() {
        LocalDate today = LocalDate.now();
        return appointmentRepository.findByApptdiagdate(today);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

}

