package com.project.hospitalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmergencyContact
{
    private String fullName;
    private String contact;
    private String relationship;
}
