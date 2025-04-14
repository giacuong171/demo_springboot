package com.xxxx.demo_spring.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "java_CCCD_001")
@Data
public class CCCDEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number_cccd;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private UserEntity user;
}
