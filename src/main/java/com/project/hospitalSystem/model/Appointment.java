package com.project.hospitalSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@FutureOrPresent(message = "enter valid date")
    private LocalDate date;
    private LocalTime time;
    private String appointStatus;
    //private  Long appointmentId;
    @ManyToOne
    @JoinColumn(name ="patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name ="doctor_id")
    private  Doctor doctor;
    private  String reason;
}
