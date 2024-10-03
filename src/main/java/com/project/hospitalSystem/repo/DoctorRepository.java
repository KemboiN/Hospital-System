package com.project.hospitalSystem.repo;

import com.project.hospitalSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsByEmail(String email);
    Optional <Doctor>findById(Doctor id);
}
