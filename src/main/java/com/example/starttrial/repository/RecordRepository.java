package com.example.starttrial.repository;

import com.example.starttrial.entity.Patient;
import com.example.starttrial.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByPatient(Patient patient);
}
