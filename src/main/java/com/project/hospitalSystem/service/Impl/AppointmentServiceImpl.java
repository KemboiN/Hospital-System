package com.project.hospitalSystem.service.Impl;

import com.project.hospitalSystem.Utils.AccountUtils;
import com.project.hospitalSystem.dto.AppointmentRequest;
import com.project.hospitalSystem.dto.EmailDetails;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.model.Appointment;
import com.project.hospitalSystem.model.Doctor;
import com.project.hospitalSystem.model.Patient;
import com.project.hospitalSystem.repo.AppointmentRepo;
import com.project.hospitalSystem.repo.DoctorRepository;
import com.project.hospitalSystem.repo.PatientRepository;
import com.project.hospitalSystem.service.AppointmentService;
import com.project.hospitalSystem.service.EmailService;
import com.project.hospitalSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    EmailService emailService;

    @Override
    public HospitalResponse BookAppointment(AppointmentRequest appointmentRequest) {
        // checking if patient exists
        Optional<Patient> patientOptional = patientRepository.findByEmail(appointmentRequest.getEmail());
        if (!patientOptional.isPresent()) {
            return HospitalResponse.builder()
                    .responseCode(AccountUtils.Patient_Not_Found_Response_Code)
                    .responseMessage(AccountUtils.Patient_Not_Found_Response_Message)
                    .build();
        }

        // checking if Doctor exists
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentRequest.getDoctorId());
        if (!doctorOptional.isPresent()) {
            return HospitalResponse.builder()
                    .responseCode(AccountUtils.Doctor_Not_Found_Response_Code)
                    .responseMessage(AccountUtils.Doctor_Not_Found_Response_Message)
                    .build();
        }


        Patient patient = patientOptional.get();
        Doctor doctor = doctorOptional.get();

        if (!appointmentRepo.existsByPatientAndDoctorAndDate(patient,doctor, appointmentRequest.getDate())) {
        Appointment appointment = Appointment.builder()
                .date(appointmentRequest.getDate())
                .reason(appointmentRequest.getReason())
                .patient(patient)
                .doctor(doctor)
                .appointStatus(appointmentRequest.getAppointStatus())
                //.appointmentId(appointmentRequest.getAppointmentId())
                .build();
        appointmentRepo.save(appointment);
            EmailDetails emailDetails= EmailDetails.builder()
                    .recipient(appointmentRequest.getEmail())
                    .subject("Appointment booking")
                    .messageBody("Congratulations, \"Your Appointment booking Was Successful")
                    .build();
            emailService.sendEmailAlert(emailDetails);

        return HospitalResponse.builder()
                .responseCode(AccountUtils.Appointment_Success_Response_Code )
                .responseMessage(AccountUtils.Appointment_Success_Saved_Response_Message)
                .build();
    }
    else {

        return HospitalResponse.builder()
                .responseCode(AccountUtils.Appointment_Exist_Response_Code)
                .responseMessage(AccountUtils.Appointment_Exist_Response_Message)
                .build();
    }
    }

    @Override
    public HospitalResponse UpdateAppointment(Long appointmentId, AppointmentRequest appointmentRequest) {
        Optional<Appointment>appointmentOptional = appointmentRepo.findById(appointmentId);

       if (!appointmentOptional.isPresent()){
           return  HospitalResponse.builder()
                   .responseCode(AccountUtils.Appointment_Does_Not_Exists_Response_Code)
                   .responseMessage(AccountUtils.Appointment_Does_Not_Exists_Response_Message)
                   .build();
       }
       Appointment existingAppointment= appointmentOptional.get();
       if (appointmentRequest.getDoctorId()!=null)
       {
           Optional<Doctor>doctorOptional= doctorRepository.findById(appointmentRequest.getDoctorId());
           if (!doctorOptional.isPresent())
           {
               return HospitalResponse.builder()
                       .responseCode(AccountUtils.Doctor_Not_Found_Response_Code)
                       .responseMessage(AccountUtils.Doctor_Not_Found_Response_Message)
                       .build();
           }
           existingAppointment.setDoctor(doctorOptional.get());

            }

        if (appointmentRequest.getDate() !=null)
        {
            existingAppointment.setDate(appointmentRequest.getDate());
        }
        if (appointmentRequest.getReason() !=null){
            existingAppointment.setReason(appointmentRequest.getReason());
        }
        appointmentRepo.save(existingAppointment);
        return HospitalResponse.builder()
                .responseCode(AccountUtils.Appointment_Update_Success_Response_Code)
                .responseMessage(AccountUtils.Appointment_Update_Success_Response_Message)
                .build();
    }

    @Override
    public HospitalResponse DeleteAppointment(Long appointmentId) {
        Optional<Appointment> optionalAppointment=(appointmentRepo.findById(appointmentId));

       if (!optionalAppointment.isPresent())
       {
           return  HospitalResponse.builder()
                   .responseCode(AccountUtils.Appointment_Does_Not_Exists_Response_Code)
                   .responseMessage(AccountUtils.Appointment_Does_Not_Exists_Response_Message)
                   .build();
       }
       appointmentRepo.deleteById(appointmentId);
        return  HospitalResponse.builder()
                .responseCode(AccountUtils.Delete_Appointment_Success_Response_Code)
                .responseMessage(AccountUtils.Delete_Appointment_Success_Response_Message)
                .build();
    }
}
