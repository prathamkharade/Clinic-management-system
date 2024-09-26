package com.example.starttrial.service;

import com.example.starttrial.entity.Patient;
import com.example.starttrial.entity.Record;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<String> getPatientNamesAndContacts();

    Patient savePatient(Patient patient);

    List<Record> findRecordsByPatient(Patient patient);

    long countTotalPatients();

    List<Patient> findAllPatientsOrderedByIdDesc();

    Optional<Patient> findPatientById(Long id);
}
