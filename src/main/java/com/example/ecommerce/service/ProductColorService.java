package com.example.ecommerce.service;

import com.example.ecommerce.payload.ProductColorDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductColorService {
    public ProductColorDto createPdColor(ProductColorDto productColorDto,Long productId);
    public ProductColorDto updatePdColor(ProductColorDto productColorDto ,Long colorId);
    public ApiResponse delete(Long colorId);
}
