package com.xxxx.demo_spring;

import com.xxxx.demo_spring.entity.feed.FeedEntity;
import com.xxxx.demo_spring.entity.user.UserEntity;
import com.xxxx.demo_spring.repository.FeedRepository;
import com.xxxx.demo_spring.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserFeedTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedRepository feedRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest(){
        UserEntity userEntity = new UserEntity();
        FeedEntity feedEntity1 = new FeedEntity();
        FeedEntity feedEntity2 = new FeedEntity();
        userEntity.setUserName("Tips Java 3");
        userEntity.setUserEmail("tipsjava3@gmail.com");
        userRepository.save(userEntity);

        feedEntity1.setTitle("feed 03");
        feedEntity1.setDescription("feed 03 description");
        feedEntity2.setTitle("feed 04");
        feedEntity2.setDescription("feed 04 description");
        feedEntity1.setUser(userEntity);
        feedEntity2.setUser(userEntity);
//        userEntity.setFeedList(List.of(feedEntity1,feedEntity2));
        feedRepository.save(feedEntity1);
        feedRepository.save(feedEntity2);
    }

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTestTwo(){
        UserEntity userEntity = new UserEntity();
        FeedEntity feedEntity1 = new FeedEntity();
        userEntity.setUserName("Tips Java 4");
        userEntity.setUserEmail("tipsjava4@gmail.com");
        feedEntity1.setTitle("feed 032");
        feedEntity1.setDescription("feed 032 description");
        feedEntity1.setUser(userEntity);
        userRepository.save(userEntity);
    }

//    @Test
//    @Transactional
//    void selectOneToManyTest(){
//        UserEntity userEntity = userRepository.findById(3L)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        System.out.println(userEntity);
//        System.out.println(userEntity.getFeedList());
//    }
}
