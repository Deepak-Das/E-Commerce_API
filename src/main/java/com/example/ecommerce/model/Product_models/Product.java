package com.example.ecommerce.model.Product_models;

import com.example.ecommerce.model.Product_models.category.Category;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.details.*;
import com.example.ecommerce.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Column(nullable = false)
    private int amount;

    @Column(length = 100)
    private String description;

    private int discount;

    @Column(nullable = false)
    private boolean available;

    //drive during response
    @Transient
    private int avgRate;

    @Transient
    private int soldCount;
    //drive during response

    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductImage> productImageList = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductShape> productShapes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductSize> productSizes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductColor> productColors = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<ProductReview> productReviews = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false,referencedColumnName = "stockId",name = "stock_id")
    private Stock stock;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductSpec> productSpecs = new HashSet<>();



    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,mappedBy = "catId")
    private Set<Category> categories=new HashSet<>();


}
