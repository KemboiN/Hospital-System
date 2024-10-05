package com.project.hospitalSystem.controller;

import com.project.hospitalSystem.dto.DoctorRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.dto.PatientRequest;
import com.project.hospitalSystem.service.DoctorService;
import com.project.hospitalSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

   @PostMapping("/createAccount")

    public HospitalResponse createAccount (@RequestBody PatientRequest patientRequest)
    {
        return patientService.createAccount(patientRequest);
    }
    @PutMapping("/updateAccountDetails")

    public HospitalResponse updateAccountDetails (@RequestBody PatientRequest patientRequest)
    {
        return patientService.updateAccountDetails(patientRequest);
    }

}
