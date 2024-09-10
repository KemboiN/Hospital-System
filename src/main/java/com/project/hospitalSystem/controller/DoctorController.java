package com.project.hospitalSystem.controller;

import com.project.hospitalSystem.dto.DoctorRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor")

    public HospitalResponse createDoctorAccount (@RequestBody DoctorRequest doctorRequest)
    {
        return doctorService.createAccount(doctorRequest);
    }
}
