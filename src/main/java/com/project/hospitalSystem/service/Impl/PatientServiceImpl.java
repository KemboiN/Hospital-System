package com.project.hospitalSystem.service.Impl;

import com.project.hospitalSystem.Utils.AccountUtils;
import com.project.hospitalSystem.dto.EmailDetails;
import com.project.hospitalSystem.dto.HospitalResponse;
import com.project.hospitalSystem.dto.PatientRequest;
import com.project.hospitalSystem.model.Patient;
import com.project.hospitalSystem.repo.PatientRepository;
import com.project.hospitalSystem.service.EmailService;
import com.project.hospitalSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            .messageBody("CONGRATULATIONS " + savedPatient.getFullName() + ",\n" +
                    "\nYou have Registered with BEST Hospital\n\n For any inquiries call 0713595565")
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

    @Override
    public HospitalResponse updateAccountDetails(PatientRequest patientRequest) {
        Optional<Patient>patientOptional=patientRepository.findByEmail(patientRequest.getEmail());
        if (!patientRepository.existsByEmail(patientRequest.getEmail()))
        {
            return HospitalResponse.builder()
                    .responseCode(AccountUtils.Account_Does_Not_Exists_Response_Code)
                    .responseMessage(AccountUtils.Account_Does_Not_Exists_Response_Message)
                    .build();
     }
 Patient updateAccountDetails = patientOptional.get();
        if (updateAccountDetails.getFullName()!=null)
        {
            updateAccountDetails.setFullName(patientRequest.getFullName());
        }
        if (updateAccountDetails.getAddress()!=null)
        {
            updateAccountDetails.setAddress(patientRequest.getAddress());
        }
        if (updateAccountDetails.getContactNumber()!=null)
        {
            updateAccountDetails.setContactNumber(patientRequest.getContactNumber());
        }
        if (updateAccountDetails.getCurrentMedications()!=null && !updateAccountDetails.getCurrentMedications().isEmpty())
        {
            updateAccountDetails.setCurrentMedications(patientRequest.getCurrentMedications());

        }
        if (updateAccountDetails.getAge()!=null)
        {
            updateAccountDetails.setAge(patientRequest.getAge());
        }
        if (updateAccountDetails.getEmail()!=null)
        {
            updateAccountDetails.setEmail(patientRequest.getEmail());
        }
        if (updateAccountDetails.getIdNumber()!=null)
        {
            updateAccountDetails.setIdNumber(patientRequest.getIdNumber());
        }
        if (updateAccountDetails.getPassword()!=null)
        {
            updateAccountDetails.setPassword(patientRequest.getPassword());
        }
        if (updateAccountDetails.getGender()!=null)
        {
            updateAccountDetails.setGender(patientRequest.getGender());
        }
        if (updateAccountDetails.getMedicalHistory()!=null)
        {
            updateAccountDetails.setMedicalHistory(patientRequest.getMedicalHistory());
        }
        patientRepository.save(updateAccountDetails);


        return HospitalResponse.builder()
                .responseCode(AccountUtils.Account_Details_Updated_Response_Code)
                .responseMessage(AccountUtils.Account_Details_Updated_Response_Message)
                .build();
    }

    @Override
    public HospitalResponse deleteAccount(Long patientId) {

        Optional<Patient>patientOptional= patientRepository.findById(patientId);
        if(patientOptional.isPresent()) {
            patientRepository.deleteById(patientId);


            return HospitalResponse.builder()
                    .responseCode(AccountUtils.Account_Deleted_Response_Code)
                    .responseMessage(AccountUtils.Account_Deleted_Response_Message)
                    .build();
        }
        else return HospitalResponse.builder()
                .responseCode(AccountUtils.Account_Does_Not_Exists_Response_Code)
                .responseMessage(AccountUtils.Account_Does_Not_Exists_Response_Message)
                .build();
    }



}
