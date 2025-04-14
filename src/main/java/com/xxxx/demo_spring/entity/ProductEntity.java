package com.xxxx.demo_spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "java_product_001")
@DynamicInsert
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'user name'",unique = true, nullable = false)
    private String productName;

    @Column(columnDefinition = "varchar(255) comment 'user name'",unique = true, nullable = false)
    private BigDecimal productPrice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "java_Product_Order_001",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<OrderEntity> orderList;
}
