package com.example.ecommerce.payload;

import com.example.ecommerce.model.Product_models.Cart;
import com.example.ecommerce.model.Product_models.category.Category;
import com.example.ecommerce.model.Product_models.details.*;
import com.example.ecommerce.model.Product_models.orders.TbOrderDetail;
import com.example.ecommerce.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class ProductDto {
    private long productId;

    @Min(value = 1)
    private int amount;

    @Size(max = 100)
    private String description;


    @Min(value = 0, message = "Discount must be provided")
    private int discount;

    @NotNull(message = "please provide availability")
    private boolean available;

    @JsonIgnore
    private int avgRate;

    @JsonIgnore
    private int soldCount;
    //drive during response

    @JsonIgnore
    private User seller;

    private Set<ProductImageDto> productImageList = new HashSet<>();

    private Set<ProductShapeDto> productShapes = new HashSet<>();

    private Set<ProductSizeDto> productSizes = new HashSet<>();

    private Set<ProductColorDto> productColors = new HashSet<>();

    private Set<ProductReviewDto> productReviews = new HashSet<>();

    private Set<ProductSpecDto> productSpecs = new HashSet<>();

    private Set<StockDto> stock=new HashSet<>();

    private Set<Category> categories=new HashSet<>();



    @NotNull
    private Set<TbOrderDetail> orderDetails = new HashSet<>();

    private Set<Cart> carts = new HashSet<>();
}
