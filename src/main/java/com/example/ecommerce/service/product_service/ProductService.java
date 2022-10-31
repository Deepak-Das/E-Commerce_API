package com.example.ecommerce.service.product_service;

import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductService {

    public ProductDto createProduct(ProductDto productDto,Long seller);
    public ProductDto updateProduct(ProductDto productDto,Long productId);
    public ProductDto productById(Long productId);


    public ApiResponse deleteProduct(Long productId);


}
