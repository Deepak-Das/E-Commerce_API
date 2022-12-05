package com.example.ecommerce.payload.Product;

import com.example.ecommerce.model.Product_models.category.Category;
import com.example.ecommerce.model.Product_models.category.ChildCategory;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.model.Product_models.details.ProductReview;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.model.Product_models.details.ProductSpec;
import com.example.ecommerce.model.Product_models.details.Stock;
import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.StockDto;
import com.example.ecommerce.payload.UserDto;
import com.example.ecommerce.payload.category.ChildCategoryDto;
import com.example.ecommerce.payload.category.MainCategoryDto;
import com.example.ecommerce.payload.category.Response.ChildCategoryDto_res;
import com.example.ecommerce.payload.category.Response.MainCategoryDto_res;
import com.example.ecommerce.payload.category.Response.SubCategoryDto_res;
import com.example.ecommerce.payload.category.SubCategoryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private long productId;

    @NotNull(message = "must have amount value")
    private int amount;

    @NotEmpty(message = "title can not be empty")
    private String title;

    @NotEmpty(message = "description can not be empty")
    @Size(max = 200,message = "description must not exceed 200 character")
    private String description;


    @Min(value = 0, message = "Discount must be provided")
    private int discount;



    @NotNull(message = "please provide availability")
    private boolean available;

    private int avgRate;


//    private int soldCount;
    //drive during response

    @JsonIgnore
    private UserDto seller;

    private Set<ProductShapeDto> productShapes = new HashSet<>();

    private Set<ProductSizeDto> productSizes = new HashSet<>();

    private Set<ProductColorDto> productColors = new HashSet<>();
    private Set<ProductImageDto> productImages = new HashSet<>();

    private MainCategoryDto_res mainCategory;
    private SubCategoryDto_res subCategory;
    private ChildCategoryDto_res childCategory;

    private Set<ProductSpecDto> productSpecs = new HashSet<>();

    private Set<ProductReviewDto> productReviews = new HashSet<>();


    private StockDto stock;



}
