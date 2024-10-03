package com.project.hospitalSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate date;
    private String appointStatus;
    @ManyToOne
    @JoinColumn(name ="patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name ="doctor_id")
    private  Doctor doctor;
    private  String reason;
}
