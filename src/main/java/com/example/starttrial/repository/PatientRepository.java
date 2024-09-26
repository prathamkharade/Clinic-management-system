package com.example.starttrial.repository;

import com.example.starttrial.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.patientdetname = :name OR p.patientdetcontact = :contact")
    Optional<Patient> findByNameOrContact(@Param("name") String name, @Param("contact") String contact);

    List<Patient> findAllByOrderByPatientIdDesc();

}
