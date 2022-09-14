package com.example.ecommerce.model.Product_models.details;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
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