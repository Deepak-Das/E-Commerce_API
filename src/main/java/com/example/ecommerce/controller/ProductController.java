package com.example.ecommerce.controller;

import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.service.product_service.ProductService;
import com.example.ecommerce.util.ApiResponse;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService  productService;

    @PostMapping({
            "products/seller/{sellerId}/main/{mainId}/sub/{subId}/child/{childId}",
            "products/seller/{sellerId}/main/{mainId}/sub/{subId}/"
    })
    ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto,
            @PathVariable("sellerId") Long sellerId,
            @PathVariable("mainId") Long mainId,
            @PathVariable("subId") Long subId,
            @PathVariable(value = "childId",required = false) Long childId
            ){
        //Todo : need categoryId
        ProductDto product = productService.createProduct(productDto,sellerId,mainId,subId,childId);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

//    @PostMapping({"/abc/{id}", "/abc"})
//    private  ResponseEntity<String> abc(@PathVariable(value = "id",required = false) Long id){
//        return ResponseEntity.ok("id.toString()");
//    }

    @GetMapping("products/{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long productId){
        ProductDto productDto = productService.productById(productId);
        return new ResponseEntity<>(productDto,HttpStatus.FOUND);
    }

    @DeleteMapping("products/{productId}")
    ResponseEntity<ApiResponse> deletePro(@PathVariable("productId") Long productId){
        ApiResponse apiResponse = productService.deleteProduct(productId);
        return ResponseEntity.ok(apiResponse);
    }
}
