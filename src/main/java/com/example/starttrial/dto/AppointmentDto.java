package com.example.starttrial.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long appointmentId;
    private Long patientId;
    private LocalDate apptdiagdate;
    private LocalTime apptdiagtime;
    private String apptdiagduration;
    private String apptdiagtreatment;
    private String apptdiagnotes;
}
