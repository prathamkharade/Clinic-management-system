package com.example.starttrial.entity;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "records")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private LocalDate addrecordsdate;
    private LocalTime addrecordstime;
    private String addrecordstoothno;
    private String addrecordstetment;
    private String addrecordsdebit;
    private String addrecordsdues;
    private String addrecordsremarks;
}
