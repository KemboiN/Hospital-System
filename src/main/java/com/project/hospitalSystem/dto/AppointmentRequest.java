package com.project.hospitalSystem.dto;

import com.project.hospitalSystem.model.Doctor;
import com.project.hospitalSystem.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentRequest {
    private LocalDate date;
    private String email;
    private Long doctorId;
    //private  Long appointmentId;
    private Patient patient;
    private String appointStatus;
    private  String reason;
}
