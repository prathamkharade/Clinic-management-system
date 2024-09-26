package com.example.starttrial.mapper;

import com.example.starttrial.dto.RecordDto;
import com.example.starttrial.entity.Record;

public class RecordMapper {

    public static RecordDto toDto (Record record) {
        return new RecordDto(
                record.getRecordId(),
                record.getPatient().getPatientId(),
                record.getAddrecordsdate(),
                record.getAddrecordstime(),
                record.getAddrecordstoothno(),
                record.getAddrecordstetment(),
                record.getAddrecordsdebit(),
                record.getAddrecordsdues(),
                record.getAddrecordsremarks()
        );
    }
}
