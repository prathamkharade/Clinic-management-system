package com.example.starttrial.serviceImpl;

import com.example.starttrial.entity.Patient;
import com.example.starttrial.entity.Record;
import com.example.starttrial.repository.PatientRepository;
import com.example.starttrial.repository.RecordRepository;
import com.example.starttrial.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<String> getPatientNamesAndContacts() {
        return patientRepository.findAll().stream()
                .map(patient -> patient.getPatientdetname() + " - " + patient.getPatientdetcontact())
                .collect(Collectors.toList());
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Record> findRecordsByPatient(Patient patient) {
        return recordRepository.findByPatient(patient);
    }

    @Override
    public long countTotalPatients() {
        return patientRepository.count();
    }

    @Override
    public List<Patient> findAllPatientsOrderedByIdDesc() {
        return patientRepository.findAllByOrderByPatientIdDesc();
    }

    public Optional<Patient> findPatientById(Long id) {
        return patientRepository.findById(id);
    }
}
