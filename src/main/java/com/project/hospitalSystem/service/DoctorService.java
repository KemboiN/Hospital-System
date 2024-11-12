package com.project.hospitalSystem.service;

import com.project.hospitalSystem.dto.DoctorRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.model.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface DoctorService
{
    HospitalResponse createAccount(DoctorRequest doctorRequest);

}
