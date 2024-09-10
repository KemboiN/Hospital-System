package com.project.hospitalSystem.service;

import com.project.hospitalSystem.dto.DoctorRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService
{
    HospitalResponse createAccount(DoctorRequest doctorRequest);
}
