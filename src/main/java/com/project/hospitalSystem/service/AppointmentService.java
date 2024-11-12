package com.project.hospitalSystem.service;

import com.project.hospitalSystem.dto.AppointmentRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.model.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public interface AppointmentService
{
 HospitalResponse BookAppointment(AppointmentRequest appointRequest);
 HospitalResponse UpdateAppointment(Long appointmentId, AppointmentRequest appointmentRequest);
 HospitalResponse DeleteAppointment (Long appointmentId);



}
