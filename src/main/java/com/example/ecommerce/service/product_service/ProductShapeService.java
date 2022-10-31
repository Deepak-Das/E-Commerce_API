package com.example.ecommerce.service.product_service;

import com.example.ecommerce.payload.Product.ProductShapeDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductShapeService {
    public ProductShapeDto createPdShape(ProductShapeDto productShapeDto,Long productId);
    public ProductShapeDto updatePdShape(ProductShapeDto productShapeDto ,Long shapeId);
    public ApiResponse delete(Long shapeId);
}
