package com.example.ecommerce.model.Product_models;

import javax.persistence.*;

@Entity
@Table(name = "product_color")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long colorId;

    @Column(nullable = false,length = 20)
    private String color;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}