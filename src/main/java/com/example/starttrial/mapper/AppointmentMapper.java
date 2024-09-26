package com.example.starttrial.mapper;

import com.example.starttrial.dto.AppointmentDto;
import com.example.starttrial.entity.Appointment;

public class AppointmentMapper {
    public static AppointmentDto toDto(Appointment appointment) {
        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getPatient().getPatientId(), // Extracting patient ID
                appointment.getApptdiagdate(),
                appointment.getApptdiagtime(),
                appointment.getApptdiagduration(),
                appointment.getApptdiagtreatment(),
                appointment.getApptdiagnotes()
        );
    }

    // The toEntity method will be removed since the service layer will handle entity creation and updating.
}
