package com.example.ecommerce.service;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.payload.ProductDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductService {

    public ProductDto createProduct(ProductDto productDto);
    public ProductDto updateProduct(ProductDto productDto,Long productId);
    public ApiResponse deleteProduct(Long productId);


}
