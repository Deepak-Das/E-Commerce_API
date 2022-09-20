package com.example.ecommerce.model.Product_models;

import com.example.ecommerce.model.Product_models.category.Category;
import com.example.ecommerce.model.Product_models.details.*;
import com.example.ecommerce.model.Product_models.orders.TbOrderDetail;
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

    @OneToMany( mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<ProductShape> productShapes = new HashSet<>();

    @OneToMany( mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<ProductSize> productSizes = new HashSet<>();

    @OneToMany( mappedBy = "product",fetch = FetchType.LAZY)
    private Set<ProductColor> productColors = new HashSet<>();

    @OneToMany( mappedBy = "product",fetch = FetchType.LAZY)
    private Set<ProductReview> productReviews = new HashSet<>();

    @OneToMany( mappedBy = "product",fetch = FetchType.LAZY)
    private Set<ProductSpec> productSpecs = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Stock> stock=new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,mappedBy = "catId")
    private Set<Category> categories=new HashSet<>();



    //Order
    @OneToMany( mappedBy = "product",fetch = FetchType.LAZY)
    private Set<TbOrderDetail> orderDetails = new HashSet<>();

    @OneToMany( mappedBy = "product",fetch = FetchType.LAZY)
    private Set<Cart> carts = new HashSet<>();


}
