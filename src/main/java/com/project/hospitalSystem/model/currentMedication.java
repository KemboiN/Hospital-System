package com.project.hospitalSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "currentMedications")
    public class currentMedication {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String dosage;
        private String frequency;
        private String route; // e.g., oral, etc.
        private Date startDate;
        private Date endDate;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    }


