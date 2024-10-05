package com.project.hospitalSystem.dto;

import com.project.hospitalSystem.model.currentMedication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequest {
    private int age;
    private Long patientId;
    private int idNumber;
    private String fullName;
    private String email;
    private String password;
    private String gender;
    private String address;
    private String contactNumber;
    private String medicalHistory;
    private List<currentMedication> currentMedications= new ArrayList<>();


}
