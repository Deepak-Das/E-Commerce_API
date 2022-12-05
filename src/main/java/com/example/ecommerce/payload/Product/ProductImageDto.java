package com.example.ecommerce.payload.Product;

import com.example.ecommerce.model.Product_models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter

public class ProductImageDto {

    private long imageId;

    private String path;
    private String type;


//    private Product product;

}