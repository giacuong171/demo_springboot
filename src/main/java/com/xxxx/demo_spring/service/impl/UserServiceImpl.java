package com.xxxx.demo_spring.service.impl;

import com.xxxx.demo_spring.entity.user.UserEntity;
import com.xxxx.demo_spring.repository.UserRepository;
import com.xxxx.demo_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findByUserNameAndUserEmail(String userName,String userEmail) {
        return userRepository.findByUserNameAndUserEmail(userName, userEmail);
    }

    @Override
    public Page<UserEntity> findAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> findByUserName(String userName, Pageable pageable) {
        return userRepository.findByUserName(userName, pageable);
    }
}
