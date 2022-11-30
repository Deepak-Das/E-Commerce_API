package com.example.ecommerce.repository.product_repo;

import com.example.ecommerce.model.Product_models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

    //Todo search product by name
    //Todo search product by main category
    //Todo search product by sub category
    //Todo search product by child category
    //Todo search product by both main sub category
    //Todo search product by both sub child category
    //Todo search product by both title and main category
    //Todo search product by both title and sub category
    //Todo search product by both title and main and sub category
    //Todo search product by both title and sub and child category
    //Todo search product by both title and main sub and child category
    //Todo check product in stock with shape
    //Todo check product in stock with size
    //Todo check product in stock with color
    //Todo check product in stock with shape and size
    //Todo check product in stock with shape and size and colour
    //Todo search product by stock availability


}
