package com.xxxx.demo_spring.repository;

import com.xxxx.demo_spring.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

}
