package com.example.starttrial.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {
    private Long recordId;
    private Long patientId;
    private LocalDate addrecordsdate;
    private LocalTime addrecordstime;
    private String addrecordstoothno;
    private String addrecordstetment;
    private String addrecordsdebit;
    private String addrecordsdues;
    private String addrecordsremarks;
}
