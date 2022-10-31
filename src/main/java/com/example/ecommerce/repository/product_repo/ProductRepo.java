package com.example.ecommerce.repository.product_repo;

import com.example.ecommerce.model.Product_models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

    //Todo search product by name
    //Todo search product by main category
    //Todo search product by sub category
    //Todo search product by child category
    //Todo search product by stock availability


}
