package com.example.ecommerce.service.product_service;

import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.util.ApiResponse;

public interface ProductService {

    public ProductDto createProduct(ProductDto dto,Long sellerId,Long mainId,Long subId,Long childId);
    public ProductDto updateProduct(ProductDto productDto,Long productId);

    public ProductDto productById(Long productId);


    public ApiResponse deleteProduct(Long productId);

    //Todo:update product mainId or subId
    //Todo:product by title/mainCat/subCat/both main & subCat
    //Todo:sort by price/rating


}
