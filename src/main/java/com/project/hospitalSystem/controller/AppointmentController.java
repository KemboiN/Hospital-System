package com.project.hospitalSystem.controller;

import com.project.hospitalSystem.dto.AppointmentRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping()
    public HospitalResponse bookAppointment(@RequestBody AppointmentRequest appointmentRequest)
    {
        return appointmentService.BookAppointment(appointmentRequest);
    }
}
