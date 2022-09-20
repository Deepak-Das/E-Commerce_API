package com.example.ecommerce.payload;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
public class ProductReviewDto {
    private Long reviewId;

    private String description;

    private int rating;



//    private Product product;


//    private User user;




}