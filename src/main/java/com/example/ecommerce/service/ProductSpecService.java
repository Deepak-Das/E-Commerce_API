package com.example.ecommerce.service;

import com.example.ecommerce.payload.ProductSizeDto;
import com.example.ecommerce.payload.ProductSpecDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductSpecService {
    public ProductSpecDto createPdSpec(ProductSpecDto productSpecDto, Long productId);
    public ProductSpecDto updatePdSpec(ProductSpecDto productSpecDto ,Long specId);
    public ApiResponse delete(Long specId);
}
