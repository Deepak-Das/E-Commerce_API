package com.example.ecommerce.service.product_service;

import com.example.ecommerce.payload.Product.ProductSizeDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductSizeService {
    public ProductSizeDto createPdColor(ProductSizeDto productSizeDto,Long productId);
    public ProductSizeDto updatePdColor(ProductSizeDto productSizeDto ,Long sizeId);
    public ApiResponse delete(Long sizeId);
}
