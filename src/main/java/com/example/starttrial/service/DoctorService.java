package com.example.starttrial.service;

import com.example.starttrial.dto.DoctorDto;

public interface DoctorService {
    boolean validateLogin(String id, String password);
}
