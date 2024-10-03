package com.project.hospitalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequest
{
    private int idNumber;
    private  String fullName;
    private String specialization;
    private String gender;
    private int age;
    private Date dob;
    private String available;
    private  String contactNumber;
    private int yearsOfExperience;
    private String department;
    private  String status; //active or on leave
    private String email;
    private String password;
}
