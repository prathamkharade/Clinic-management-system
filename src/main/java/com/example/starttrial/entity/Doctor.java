package com.example.starttrial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    private String id;
    private String password;
}
