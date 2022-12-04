package com.example.ecommerce.model.Product_models.details;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.orders.TbOrderDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_shape")
@Getter
@Setter
@NoArgsConstructor
public class ProductShape {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long shapeId;

    @Column(nullable = false)
    private String shape;


    @ManyToOne()
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stock_id")
    private Stock stock;












}