package com.example.ecommerce.service;

import com.example.ecommerce.payload.ProductSizeDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductSizeService {
    public ProductSizeDto createPdColor(ProductSizeDto productSizeDto,Long productId);
    public ProductSizeDto updatePdColor(ProductSizeDto productSizeDto ,Long sizeId);
    public ApiResponse delete(Long sizeId);
}
