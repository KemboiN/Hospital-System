package com.project.hospitalSystem.service.Impl;

import com.project.hospitalSystem.Utils.AccountUtils;
import com.project.hospitalSystem.dto.DoctorRequest;
import com.project.hospitalSystem.dto.EmailDetails;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.model.Doctor;
import com.project.hospitalSystem.repo.DoctorRepository;
import com.project.hospitalSystem.service.DoctorService;
import com.project.hospitalSystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @Service
   public class DoctorServiceImpl implements DoctorService
    {
        @Autowired
        DoctorRepository doctorRepository;
        @Autowired
        private EmailService emailService;
        @Override
        public HospitalResponse createAccount(DoctorRequest doctorRequest) {
                if (!doctorRepository.existsByEmail(doctorRequest.getEmail()))
                {
                    Doctor doctor= Doctor.builder()
                            .age(doctorRequest.getAge())
                            .fullName(doctorRequest.getFullName())
                            .dob(doctorRequest.getDob())
                            .gender(doctorRequest.getGender())
                            .email(doctorRequest.getEmail())
                            .password(doctorRequest.getPassword())
                            .specialization(doctorRequest.getSpecialization())
                            .idNumber(doctorRequest.getIdNumber())
                            .contactNumber(doctorRequest.getContactNumber())
                            .department(doctorRequest.getDepartment())
                            .status(doctorRequest.getStatus())
                            .yearsOfExperience(doctorRequest.getYearsOfExperience())
                            .build();
                    Doctor savedDoctor= doctorRepository.save(doctor);
                    EmailDetails emailDetails=EmailDetails.builder()
                            .recipient(doctorRequest.getEmail())
                            .subject("Account Creation")
                            .messageBody("CONGRATULATIONS DAKTARI " +  savedDoctor.getFullName() + " \n\n  You have Successfully registered with BEST Hospital. " + "We surely can't wait for your services")
                            .build();

                    emailService.sendEmailAlert(emailDetails);

                    return  HospitalResponse.builder()
                            .responseCode(AccountUtils.Account_Creation_Response_Code)
                            .responseMessage(AccountUtils.Account_Creation_Response_Message)
                            .build();
                }
                else {
                    return HospitalResponse.builder()
                            .responseCode(AccountUtils.Account_Exists_Response_Code)
                            .responseMessage(AccountUtils.Account_Exists_Response_Message)

                            .build();
                }



        }}

