package com.example.ecommerce.payload.Product;

import com.example.ecommerce.model.Product_models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
public class ProductSpecDto {
    private Long specId;

    private String title;
    private String description;

//    private Product product;


}