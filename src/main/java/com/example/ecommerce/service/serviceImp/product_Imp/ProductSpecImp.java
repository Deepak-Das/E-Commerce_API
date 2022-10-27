package com.example.ecommerce.service.serviceImp.product_Imp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductSpec;
import com.example.ecommerce.payload.Product.ProductSpecDto;
import com.example.ecommerce.repository.product_repo.ProductRepo;
import com.example.ecommerce.repository.product_repo.ProductSpecRepo;
import com.example.ecommerce.service.product_service.ProductSpecService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSpecImp implements ProductSpecService {
    @Autowired
    private ProductSpecRepo productSpecRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductSpecDto createPdSpec(ProductSpecDto productSpecDto, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        ProductSpec productSpec = mapper.map(productSpecDto, ProductSpec.class);
        ProductSpecDto specDto = mapper.map(productSpecRepo.save(productSpec), ProductSpecDto.class);
        return specDto;
    }

    @Override
    public ProductSpecDto updatePdSpec(ProductSpecDto productSpecDto, Long specId) {
        ProductSpec productSpec = productSpecRepo.findById(specId).orElseThrow(() -> new ResourceNotFoundException("ProductSpec", "specId", specId.toString()));
        productSpec.setTitle(productSpecDto.getTitle());
        productSpec.setDescription(productSpecDto.getDescription());
        return mapper.map(productSpecRepo.save(productSpec),ProductSpecDto.class);
    }

    @Override
    public ApiResponse delete(Long specId) {
        ProductSpec productSpec = productSpecRepo.findById(specId).orElseThrow(() -> new ResourceNotFoundException("ProductSpec", "specId", specId.toString()));
        productSpecRepo.delete(productSpec);
        return new ApiResponse("deleted Successfully");
    }
}
