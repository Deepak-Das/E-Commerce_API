package com.example.ecommerce.service;

import com.example.ecommerce.payload.ProductSizeDto;

public interface ProductSpecService {
    public ProductSizeDto createPdColor(ProductSizeDto productSizeDto,Long productId);
    public ProductSizeDto updatePdColor(ProductSizeDto productSizeDto ,Long specId);
    public void delete(ProductSizeDto productSizeDto ,Long specId);
}
