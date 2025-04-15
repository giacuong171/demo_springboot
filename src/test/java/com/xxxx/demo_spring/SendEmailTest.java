package com.xxxx.demo_spring;

import com.xxxx.demo_spring.util.EmailSenderUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {
    @Autowired
    private EmailSenderUtil emailSenderUtil;
    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    void sendTextEmail(){
        String to = "giacuong171@gmail.com";
        String subject = "Test OTP simple";
        String content = "This is a test";
        emailSenderUtil.sendTextMail(to, subject, content);
    }

    @Test
    void sendHmlEmail() throws IOException {
        String to = "giacuong171@gmail.com";
        String subject = "Test OTP HTML";
        String content = "This is a test";

        Resource resource = new ClassPathResource("/templates/email/otp-auth.html");
        String htmlContent = new String(resource.getInputStream().readAllBytes());
        emailSenderUtil.sendHtmlEmail(to, subject, content);
    }
}
