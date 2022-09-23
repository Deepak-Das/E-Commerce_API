package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.payload.ProductDto;
import com.example.ecommerce.repository.ProductRepo;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        Product save = productRepo.save(product);
        return mapper.map(save,ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto,Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setAmount(productDto.getAmount());
        product.setDiscount(productDto.getDiscount());
        Product save = productRepo.save(product);

        return mapper.map(save,ProductDto.class);
    }

    @Override
    public ApiResponse deleteProduct(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        productRepo.delete(product);
        return new ApiResponse("deleted successfully");
    }
}
