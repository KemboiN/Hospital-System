package com.project.hospitalSystem.service;

import com.project.hospitalSystem.dto.EmailDetails;
import org.springframework.stereotype.Service;

@Service
public interface EmailService
{

    void  sendEmailAlert(EmailDetails emailDetails);

}
