package com.example.ecommerce.model.Product_models;

import javax.persistence.*;

@Entity
@Table(name = "product_spec")
public class ProductSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long specId;

    @Column(nullable = false,length = 15)
    private String title;
    @Column(nullable = false,length = 40)
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}