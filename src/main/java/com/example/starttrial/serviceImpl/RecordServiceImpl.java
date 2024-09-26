package com.example.starttrial.serviceImpl;

import com.example.starttrial.dto.RecordDto;
import com.example.starttrial.entity.Patient;
import com.example.starttrial.entity.Record;
import com.example.starttrial.repository.PatientRepository;
import com.example.starttrial.repository.RecordRepository;
import com.example.starttrial.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }
}
