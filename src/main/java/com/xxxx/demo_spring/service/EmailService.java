package com.xxxx.demo_spring.service;

import com.xxxx.demo_spring.entity.mail.EmailEntity;

public interface EmailService {

    String sendTextEmail(EmailEntity email);
}
