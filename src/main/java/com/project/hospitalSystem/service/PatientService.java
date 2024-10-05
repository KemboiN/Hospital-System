package com.project.hospitalSystem.service;

import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.dto.PatientRequest;
import org.springframework.stereotype.Service;

@Service
public interface PatientService
{
HospitalResponse createAccount(PatientRequest patientRequest);
HospitalResponse updateAccountDetails(PatientRequest patientRequest);
}
