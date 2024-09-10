package com.project.hospitalSystem.repo;

import com.project.hospitalSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long> {
    boolean existsByEmail(String email);
}
