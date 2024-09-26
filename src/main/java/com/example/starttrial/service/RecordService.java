package com.example.starttrial.service;

import com.example.starttrial.dto.RecordDto;
import com.example.starttrial.entity.Record;

public interface RecordService {
    Record saveRecord(Record record);
}
