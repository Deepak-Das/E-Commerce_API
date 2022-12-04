package com.example.ecommerce.payload;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.model.Product_models.details.ProductSize;
import com.example.ecommerce.payload.Product.ProductColorDto;
import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.payload.Product.ProductShapeDto;
import com.example.ecommerce.payload.Product.ProductSizeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class StockDto {
    @JsonIgnore
    private Long stockId;

    private int credit;
    private int debate;


    private int count;

    @JsonIgnore
    private ProductDto product;







}