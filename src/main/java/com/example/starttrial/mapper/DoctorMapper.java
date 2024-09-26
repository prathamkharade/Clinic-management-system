package com.example.starttrial.mapper;

import com.example.starttrial.dto.DoctorDto;
import com.example.starttrial.entity.Doctor;

public class DoctorMapper {

    public static DoctorDto toDto(Doctor doctor) {
        return new DoctorDto(doctor.getId(), doctor.getPassword());
    }

    public static Doctor toEntity(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getId(), doctorDto.getPassword());
    }
}
