package com.project.hospitalSystem.controller;

import com.project.hospitalSystem.dto.DoctorRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.dto.PatientRequest;
import com.project.hospitalSystem.service.DoctorService;
import com.project.hospitalSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

   @PostMapping()

    public HospitalResponse createAccount (@RequestBody PatientRequest patientRequest)
    {
        return patientService.createAccount(patientRequest);
    }

}
