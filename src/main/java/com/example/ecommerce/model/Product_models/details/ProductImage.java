package com.example.ecommerce.model.Product_models.details;

import com.example.ecommerce.model.Product_models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "products_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long imageId;

    @Column(nullable = false)
    private String path;
    @Column(nullable = false)
    private String imageName;
    @Column(nullable = false)
    private String type;

    //Todo:image with different color (one to Many with Color)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}