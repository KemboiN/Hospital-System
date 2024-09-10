package com.project.hospitalSystem.service;

import com.project.hospitalSystem.Utils.AccountUtils;
import com.project.hospitalSystem.dto.DoctorRequest;
import com.project.hospitalSystem.dto.EmailDetails;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.dto.PatientRequest;
import com.project.hospitalSystem.model.Patient;
import com.project.hospitalSystem.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
   private EmailService emailService;
    @Override
    public HospitalResponse createAccount(PatientRequest patientRequest) {
if(!patientRepository.existsByEmail(patientRequest.getEmail()))
{
    Patient patient= Patient.builder()
            .fullName(patientRequest.getFullName())
            .email(patientRequest.getEmail())
            .password(patientRequest.getPassword())
            .age(patientRequest.getAge())
            .idNumber(patientRequest.getIdNumber())
            .address(patientRequest.getAddress())
            .gender(patientRequest.getGender())
            .contactNumber(patientRequest.getContactNumber())
            .medicalHistory(patientRequest.getMedicalHistory())
            .currentMedications(patientRequest.getCurrentMedications())
            .build();
    Patient savedPatient=patientRepository.save(patient);
    EmailDetails emailDetails=EmailDetails.builder()
            .recipient(patientRequest.getEmail())
            .subject("Account Creation")
            .messageBody("CONGRATULATIONS " + savedPatient.getFullName() + ",\n\nYou have Registered with BEST Hospital\n\n For any inquiries call 0713595565")
            .build();
   emailService.sendEmailAlert(emailDetails);
    return HospitalResponse.builder()
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
}



}
