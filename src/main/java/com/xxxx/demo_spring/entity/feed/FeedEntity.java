package com.xxxx.demo_spring.entity.feed;

import com.xxxx.demo_spring.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "java_feed_001")
public class FeedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "feedId")
    private long id;
    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    /*
    CascadeType.DETACH:
    CascadeType.MERGE:
    CascadeType.PERSIST:
     */

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "userId",nullable = false) // Foreignkey FeedEntity
    private UserEntity user;

}

