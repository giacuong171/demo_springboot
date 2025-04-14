package com.xxxx.demo_spring.service;

import com.xxxx.demo_spring.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductEntity product);
    List<ProductEntity> findAllProducts();
}
