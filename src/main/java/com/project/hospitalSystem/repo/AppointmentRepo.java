package com.project.hospitalSystem.repo;

import com.project.hospitalSystem.model.Appointment;
import com.project.hospitalSystem.model.Doctor;
import com.project.hospitalSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AppointmentRepo extends JpaRepository<Appointment, Long>
{
    boolean existsById( Long id);
    boolean existsByPatientAndDoctorAndDate(Patient patient, Doctor doctor, LocalDate date);
    Optional<Appointment>findById(Long id);


}
