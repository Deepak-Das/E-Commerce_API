package com.example.ecommerce.payload;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductColor;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.model.Product_models.details.ProductSize;
import com.example.ecommerce.payload.Product.ProductColorDto;
import com.example.ecommerce.payload.Product.ProductShapeDto;
import com.example.ecommerce.payload.Product.ProductSizeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class StockDto {
    private Long stockId;

    private int credit;
    private int debate;

    private ProductShapeDto shape;
    private ProductSizeDto size;
    private ProductColorDto color;

//    private Product product;






}