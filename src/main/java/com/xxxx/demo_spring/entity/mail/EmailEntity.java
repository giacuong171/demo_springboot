package com.xxxx.demo_spring.entity.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {
    private String toEmailAdress;
    private String subject;
    private String content;
    public String attachment;
}
