package com.example.ecommerce.service.serviceImp.product_Imp;

import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.category.ChildCategory;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.model.Product_models.details.*;
import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.Product.ProductDto;
import com.example.ecommerce.payload.Product.ProductImageDto;
import com.example.ecommerce.repository.UserRepo;
import com.example.ecommerce.repository.category_repo.ChildCategoryRepo;
import com.example.ecommerce.repository.category_repo.MainCategoryRepo;
import com.example.ecommerce.repository.category_repo.SubCategoryRepo;
import com.example.ecommerce.repository.product_repo.ProductImageRepo;
import com.example.ecommerce.repository.product_repo.ProductRepo;
import com.example.ecommerce.repository.product_repo.ProductShapeRepo;
import com.example.ecommerce.repository.product_repo.ProductSpecRepo;
import com.example.ecommerce.service.product_service.FileService;
import com.example.ecommerce.service.product_service.ProductService;
import com.example.ecommerce.util.ApiConstant;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepo productRepo;
    private final UserRepo sellerRepo;


    private final MainCategoryRepo mainCategory;


    private final SubCategoryRepo subCategory;
    private final ChildCategoryRepo childCategory;

    private final ModelMapper mapper;

    private final ProductShapeRepo productShapeRepo;
    private final ProductSpecRepo productSpecRepo;

    private final ProductImageRepo productImageRepo;

    private final FileService fileService;

    @Autowired
    public ProductServiceImp(ProductRepo productRepo, UserRepo sellerRepo, MainCategoryRepo mainCategory, SubCategoryRepo subCategory, ChildCategoryRepo childCategory, ModelMapper mapper, ProductShapeRepo productShapeRepo, ProductSpecRepo productSpecRepo, FileService fileService, ProductImageRepo productImageRepo) {
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
        this.childCategory = childCategory;
        this.mapper = mapper;
        this.productShapeRepo = productShapeRepo;
        this.productSpecRepo = productSpecRepo;
        this.fileService = fileService;
        this.productImageRepo = productImageRepo;
    }

    @Override
    public ProductDto createProduct(ProductDto dto, Long sellerId, Long mainId, Long subId, Long childId) {

        //todo:needed category Id -> product ->Images->stock

        User seller = sellerRepo.findById(sellerId).orElseThrow(() -> new ResourceNotFoundException("User", "sellerId", sellerId.toString()));

        ChildCategory child_Category = null;

        MainCategory main_Category = mainCategory.findById(mainId).orElseThrow(() -> new ResourceNotFoundException("Main category", "mainId", mainId.toString()));
        SubCategory sub_Category = subCategory.findById(subId).orElseThrow(() -> new ResourceNotFoundException("Sub category", "subId", subId.toString()));


        if (childId != null)
            child_Category = childCategory.findById(childId).orElseThrow(() -> new ResourceNotFoundException("Child category", "childId", childId.toString()));


        Product product = new Product();

        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setAmount(dto.getAmount());
        product.setDiscount(dto.getDiscount());
        product.setUser(seller);
        product.setMainCategory(main_Category);
        product.setSubCategory(sub_Category);
        product.setChildCategory(child_Category);


        Set<ProductSpec> specs = dto.getProductSpecs().stream().map(specDto -> {
            ProductSpec spec = mapper.map(specDto, ProductSpec.class);
            spec.setProduct(product);
            return spec;
        }).collect(Collectors.toSet());

        product.setProductSpecs(specs);

        Set<ProductShape> shapes = dto.getProductShapes().stream().map(shapeDto -> {
            ProductShape shape = mapper.map(shapeDto, ProductShape.class);
            shape.setProduct(product);
            Stock stock = mapper.map(shapeDto.getStock(), Stock.class);
            shape.setStock(stock);

            return shape;
        }).collect(Collectors.toSet());

        product.setProductShapes(shapes);

        Set<ProductSize> sizes = dto.getProductSizes().stream().map(sizeDto -> {
            ProductSize size = mapper.map(sizeDto, ProductSize.class);
            size.setProduct(product);
            Stock stock = mapper.map(sizeDto.getStock(), Stock.class);
            size.setStock(stock);
            return size;
        }).collect(Collectors.toSet());

        product.setProductSizes(sizes);

        Set<ProductColor> colors = dto.getProductColors().stream().map(colorDto -> {
            ProductColor color = mapper.map(colorDto, ProductColor.class);
            color.setProduct(product);
            Stock stock = mapper.map(colorDto.getStock(), Stock.class);
            color.setStock(stock);
            return color;
        }).collect(Collectors.toSet());

        product.setProductColors(colors);

        Stock stock = mapper.map(dto.getStock(), Stock.class);
        product.setStock(stock);


        Product productSave = productRepo.save(product);


        return mapper.map(productSave, ProductDto.class);

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

        productRepo.delete(product);
        return new ApiResponse("deleted successfully");
    }

    @Override
    public ProductImageDto uploadImg(String path, MultipartFile file, Long productId, String type) throws IOException {

        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId.toString()));
        ProductImage image = new ProductImage();


        String name = fileService.uploadImg(path, file);
        String url = "localhost:8080/api/products/image/" + name;

        boolean exists = productImageRepo.existsByProductAndTypeIgnoreCase(product, ApiConstant.IMAGE_TYPE_MAIN);

        if (type.equalsIgnoreCase(ApiConstant.IMAGE_TYPE_MAIN)) {
            if (exists) throw new AlreadyExistException("image", "type", "Main");
            image.setType(ApiConstant.IMAGE_TYPE_MAIN);
        } else image.setType(ApiConstant.IMAGE_TYPE_NORMAL);

        image.setPath(url);
        image.setProduct(product);

        ProductImage save = productImageRepo.save(image);
        return mapper.map(save, ProductImageDto.class);


    }

    @Override
    public InputStream downloadImg(String path, String fileName) throws IOException {
        return fileService.getResource(path, fileName);
    }


    @Override
    public ApiResponse deleteProductImage(String path, Long imageId) {

        ProductImage productImage = productImageRepo.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("Image", "imageId", imageId.toString()));

        String url = productImage.getPath();
        String name = url.substring(url.lastIndexOf(File.separator));


        boolean deleted = fileService.deleteImg(path, name);

        productImageRepo.save(productImage.removeProduct(productImage.getProduct()));

        if (deleted) {
            return new ApiResponse("deleted successfully");
        }

        return new ApiResponse("delete failed");

    }
}
