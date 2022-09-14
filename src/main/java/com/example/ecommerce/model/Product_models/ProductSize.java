package com.example.ecommerce.model.Product_models;


import javax.persistence.*;

@Entity
@Table(name = "product_size")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long sizeId;

    @Column(nullable = false)
    private String size;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}