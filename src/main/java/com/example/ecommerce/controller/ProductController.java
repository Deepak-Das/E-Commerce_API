package com.example.ecommerce.controller;

import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService  productService;

    @PostMapping("products/seller/{sellerId}")
    ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, @PathVariable("sellerId") Long sellerId){
        //Todo : need categoryId
        ProductDto product = productService.createProduct(productDto,sellerId);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("products/{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long productId){
        ProductDto productDto = productService.productById(productId);
        return new ResponseEntity<>(productDto,HttpStatus.FOUND);
    }
}
