package com.example.ecommerce.service.product_service;

import com.example.ecommerce.payload.Product.ProductSpecDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductSpecService {
    public ProductSpecDto createPdSpec(ProductSpecDto productSpecDto, Long productId);
    public ProductSpecDto updatePdSpec(ProductSpecDto productSpecDto ,Long specId);
    public ApiResponse delete(Long specId);
}
