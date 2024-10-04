package com.project.hospitalSystem.controller;

import com.project.hospitalSystem.dto.AppointmentRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.repo.AppointmentRepo;
import com.project.hospitalSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    AppointmentRepo appointmentRepo;

    @PostMapping("/appointment")
    public HospitalResponse bookAppointment(@RequestBody AppointmentRequest appointmentRequest)
    {
        return appointmentService.BookAppointment(appointmentRequest);
    }
    @PutMapping("/UpdateAppointment/{appointmentId}")
    public HospitalResponse UpdateAppointment(@PathVariable Long appointmentId,
                                              @RequestBody AppointmentRequest appointmentRequest)
    {
        return appointmentService.UpdateAppointment(appointmentId, appointmentRequest);
    }
    @DeleteMapping("/DeleteAppointment/{appointmentId}")
    public HospitalResponse DeleteAppointment(@PathVariable Long appointmentId)
    {
        return appointmentService.DeleteAppointment(appointmentId);
    }
}
