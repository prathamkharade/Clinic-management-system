package com.example.starttrial.mapper;

import com.example.starttrial.dto.PatientDto;
import com.example.starttrial.entity.Patient;

public class PatientMapper {

    public static PatientDto toDto(Patient patient) {
        return new PatientDto(
                patient.getPatientId(),
                patient.getPatientdetregisdate(),
                patient.getPatientdetname(),
                patient.getPatientdetbloodgrp(),
                patient.getPatientdetcontact(),
                patient.getPatientdetbirthdate(),
                patient.getPatientdetemail(),
                patient.getPatientdetaddress(),
                patient.getPatientdetchk1(),
                patient.getPatientdetchk2(),
                patient.getPatientdetchk3(),
                patient.getPatientdetchk4(),
                patient.getPatientdetchk5(),
                patient.getPatientdetchk6(),
                patient.getPatientdetchk7(),
                patient.getPatientdetchk8(),
                patient.getPatientdetchk9(),
                patient.getPatientdetchk10(),
                patient.getPatientdetchk11(),
                patient.getPatientdetchk12(),
                patient.getPatientdetchk13(),
                patient.getPatientdetchk14(),
                patient.getPatientdetmedication(),
                patient.getPatientdetallergy(),
                patient.getTreatmenthistory(),
                patient.getPatientdetadvice()
        );
    }

    public static Patient toEntity(PatientDto patientDto) {
        return new Patient(
                patientDto.getPatientId(),
                patientDto.getPatientdetregisdate(),
                patientDto.getPatientdetname(),
                patientDto.getPatientdetbloodgrp(),
                patientDto.getPatientdetcontact(),
                patientDto.getPatientdetbirthdate(),
                patientDto.getPatientdetemail(),
                patientDto.getPatientdetaddress(),
                patientDto.getPatientdetchk1(),
                patientDto.getPatientdetchk2(),
                patientDto.getPatientdetchk3(),
                patientDto.getPatientdetchk4(),
                patientDto.getPatientdetchk5(),
                patientDto.getPatientdetchk6(),
                patientDto.getPatientdetchk7(),
                patientDto.getPatientdetchk8(),
                patientDto.getPatientdetchk9(),
                patientDto.getPatientdetchk10(),
                patientDto.getPatientdetchk11(),
                patientDto.getPatientdetchk12(),
                patientDto.getPatientdetchk13(),
                patientDto.getPatientdetchk14(),
                patientDto.getPatientdetmedication(),
                patientDto.getPatientdetallergy(),
                patientDto.getTreatmenthistory(),
                patientDto.getPatientdetadvice()
        );
    }
}
