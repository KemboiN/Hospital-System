package com.project.hospitalSystem.service;

import com.project.hospitalSystem.dto.AppointmentRequest;
import com.project.hospitalSystem.dto.HospitalResponse;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService
{
 HospitalResponse BookAppointment(AppointmentRequest appointRequest);
 HospitalResponse UpdateAppointment(Long appointmentId, AppointmentRequest appointmentRequest);

}
