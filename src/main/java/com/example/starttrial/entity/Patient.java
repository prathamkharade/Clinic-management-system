package com.example.starttrial.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private LocalDate patientdetregisdate;
    private String patientdetname;
    private String patientdetbloodgrp;
    private String patientdetcontact;
    private LocalDate patientdetbirthdate;
    private String patientdetemail;
    private String patientdetaddress;

    private Boolean patientdetchk1;
    private Boolean patientdetchk2;
    private Boolean patientdetchk3;
    private Boolean patientdetchk4;
    private Boolean patientdetchk5;
    private Boolean patientdetchk6;
    private Boolean patientdetchk7;
    private Boolean patientdetchk8;
    private Boolean patientdetchk9;
    private Boolean patientdetchk10;
    private Boolean patientdetchk11;
    private Boolean patientdetchk12;
    private Boolean patientdetchk13;
    private Boolean patientdetchk14;

    private String patientdetmedication;
    private String patientdetallergy;
    private Boolean treatmenthistory;
    private String patientdetadvice;
}
