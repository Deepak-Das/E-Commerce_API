package com.example.ecommerce.model.Product_models;

import com.example.ecommerce.model.User;

import javax.persistence.*;

@Entity
@Table(name = "product_review")
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long reviewId;

    @Column(nullable = false,length = 100)
    private String description;

    @Column(nullable = false)
    private int rating;



    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




}