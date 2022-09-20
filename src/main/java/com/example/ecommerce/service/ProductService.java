package com.example.ecommerce.service;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.payload.ProductDto;

public interface ProductService {

    public ProductDto createProduct(ProductDto productDto);
    public ProductDto updateProduct(ProductDto productDto);
    public ProductDto deleteProduct(ProductDto productDto);


}
