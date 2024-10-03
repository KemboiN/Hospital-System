package com.project.hospitalSystem.service.Impl;

import com.project.hospitalSystem.dto.EmailDetails;
import com.project.hospitalSystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
@Autowired
 private JavaMailSender javaMailSender;
  @Value("${spring.mail.username}")
  private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {
        try {
            SimpleMailMessage mailMessage=  new SimpleMailMessage();
            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setSubject(emailDetails.getSubject());
            mailMessage.setText(emailDetails.getMessageBody());
            javaMailSender.send(mailMessage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("mail sent successfully");

    }
}
