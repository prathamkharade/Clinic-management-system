package com.example.starttrial.repository;

import com.example.starttrial.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    long countByApptdiagdate(LocalDate date);

    List<Appointment> findByApptdiagdate(LocalDate today);

}
