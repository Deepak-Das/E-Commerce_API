package com.example.ecommerce.service.serviceImp.product_Imp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.category.ChildCategory;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.model.Product_models.details.ProductShape;
import com.example.ecommerce.model.Product_models.details.ProductSpec;
import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.repository.category_repo.ChildCategoryRepo;
import com.example.ecommerce.repository.category_repo.MainCategoryRepo;
import com.example.ecommerce.repository.category_repo.SubCategoryRepo;
import com.example.ecommerce.repository.product_repo.ProductRepo;
import com.example.ecommerce.repository.product_repo.ProductShapeRepo;
import com.example.ecommerce.repository.product_repo.ProductSpecRepo;
import com.example.ecommerce.repository.UserRepo;
import com.example.ecommerce.service.product_service.ProductService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo sellerRepo;

    @Autowired
    private ProductShapeRepo productShapeRepo;
    @Autowired
    private ProductSpecRepo productSpecRepo;

    @Autowired
    private MainCategoryRepo mainCategory;


    @Autowired
    private SubCategoryRepo subCategory;
    @Autowired
    private ChildCategoryRepo childCategory;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductDto createProduct(ProductDto dto,Long sellerId,Long mainId,Long subId,Long childId) {

        //todo:needed category Id -> product ->Images->stock

        User seller = sellerRepo.findById(sellerId).orElseThrow(() -> new ResourceNotFoundException("User", "sellerId", sellerId.toString()));

        ChildCategory child_Category=null;

        MainCategory main_Category = mainCategory.findById(mainId).orElseThrow(() -> new ResourceNotFoundException("Main category", "mainId", mainId.toString()));
        SubCategory sub_Category = subCategory.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub category", "subId", subId.toString()));

//        if(childId!=null)
//            child_Category= childCategory.findById(childId).orElseThrow(() -> new ResourceNotFoundException("Child category", "childId", childId.toString()));



        Product product = new Product();

        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setAmount(dto.getAmount());
        product.setDiscount(dto.getDiscount());
        product.setUser(seller);
        product.setMainCategory(main_Category);
        product.setSubCategory(sub_Category);
//        product.setChildCategory(child_Category);

//        dto.getProductShapes().forEach(productShapeDto -> product.addProductShape(mapper.map(this,ProductShape.class)));



        Product save = productRepo.save(product);

        Set<ProductShape> productShapes = dto.getProductShapes().stream().map(productShapeDto -> {
                ProductShape map = mapper.map(productShapeDto, ProductShape.class);
                map.setProduct(save);
                return map;
                }

        ).collect(Collectors.toSet());

        Set<ProductSpec> productSpecs = dto.getProductSpecs().stream().map(productSpecDto -> {
            ProductSpec map = mapper.map(productSpecDto, ProductSpec.class);
            map.setProduct(save);
            return map;
        }).collect(Collectors.toSet());

        productShapeRepo.saveAll(productShapes);
        productSpecRepo.saveAll(productSpecs);

//        save.getma;

        return productById(save.getProductId());



    }


    @Override
    public ProductDto productById(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));

        //Todo:soldCount,avgRate value needed to calculate and set
        //Todo:availability need to calculated by product

        return mapper.map(product, ProductDto.class);

    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setAmount(productDto.getAmount());
        product.setDiscount(productDto.getDiscount());
        Product save = productRepo.save(product);

        return mapper.map(save, ProductDto.class);
    }

    @Override
    public ApiResponse deleteProduct(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
//        product.removeMain();
//        product.removeSub();
        productRepo.delete(product);
        return new ApiResponse("deleted successfully");
    }
}
