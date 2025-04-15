package com.xxxx.demo_spring.service.impl;

import com.xxxx.demo_spring.entity.mail.EmailEntity;
import com.xxxx.demo_spring.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String EMAIL_HOST;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendTextEmail(EmailEntity email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getToEmailAdress());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        message.setFrom(EMAIL_HOST);

        try {
            javaMailSender.send(message);
            System.out.println("EMAIl sent successfully");
            return "Email sent successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
