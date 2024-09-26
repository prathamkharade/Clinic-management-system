package com.example.starttrial.serviceImpl;

import com.example.starttrial.dto.DoctorDto;
import com.example.starttrial.entity.Doctor;
import com.example.starttrial.repository.DoctorRepository;
import com.example.starttrial.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public boolean validateLogin(String id, String password) {
        return doctorRepository.findById(id)
                .map(doctor -> doctor.getPassword().equals(password))
                .orElse(false);
    }
}
