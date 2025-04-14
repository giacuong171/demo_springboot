package com.xxxx.demo_spring.repository;

import com.xxxx.demo_spring.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//    ProductEntity createProduct(ProductEntity product);
//    List<ProductEntity> findAllProducts();
}
