package com.example.ecommerce.payload.category;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.payload.Product.ProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {

    private Long catId;

    private MainCategoryDto mainCategory;

    private SubCategoryDto subCategory;

    private ChildCategoryDto childCategory;

//    private ProductDto product;



}