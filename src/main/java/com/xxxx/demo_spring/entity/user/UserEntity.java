package com.xxxx.demo_spring.entity.user;

import com.xxxx.demo_spring.entity.feed.FeedEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@Entity
@Table(name = "java_user_001")
@DynamicInsert
@DynamicUpdate
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'user name'",unique = true, nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255) comment 'user name'",unique = true, nullable = false)
    private String userEmail;

    /*
    Orphanremove=True -> automatic remove
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FeedEntity> feedList;

}
