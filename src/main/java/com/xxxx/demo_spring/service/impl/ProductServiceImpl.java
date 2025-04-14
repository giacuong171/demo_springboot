package com.xxxx.demo_spring.service.impl;

import com.xxxx.demo_spring.entity.ProductEntity;
import com.xxxx.demo_spring.repository.ProductRepository;
import com.xxxx.demo_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product){
        return productRepository.save(product);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }
}
