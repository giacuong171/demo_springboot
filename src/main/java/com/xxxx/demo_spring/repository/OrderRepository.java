package com.xxxx.demo_spring.repository;

import com.xxxx.demo_spring.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
