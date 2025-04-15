package com.xxxx.demo_spring.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderUtil {
    @Value("${spring.mail.username}")
    private String EMAIL_HOST ;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTextMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(EMAIL_HOST);
        try {
            javaMailSender.send(message);
            System.out.println("Email sent successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendHtmlEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            MimeMessage html_mess = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(html_mess, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(html_mess);
            System.out.println("Email sent HTML successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
