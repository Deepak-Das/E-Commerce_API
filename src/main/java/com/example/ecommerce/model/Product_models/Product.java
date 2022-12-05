package com.example.ecommerce.model.Product_models;

import com.example.ecommerce.model.Product_models.category.ChildCategory;
import com.example.ecommerce.model.Product_models.category.MainCategory;
import com.example.ecommerce.model.Product_models.category.SubCategory;
import com.example.ecommerce.model.Product_models.details.*;
import com.example.ecommerce.model.Product_models.orders.TbOrderDetail;
import com.example.ecommerce.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

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

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 200)
    private String description;


    private int discount;


    @Column(nullable = false)
    private boolean available;

    //drive during response
//    @Transient
//    private int avgRate;
//



    @ManyToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ProductImage> productImages = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProductShape> productShapes = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProductSize> productSizes = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProductColor> productColors = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductReview> productReviews = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProductSpec> productSpecs = new HashSet<>();




    //Order
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<TbOrderDetail> orderDetails = new HashSet<>();

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "main_Cat_Id")
    private MainCategory mainCategory;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Sub_Cat_Id")
    private SubCategory subCategory;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Child_Cat_Id", nullable = true)
    private ChildCategory childCategory;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stock_id")
    private Stock stock;


//    @Formula("stock.debate")
//    private int soldCount;



//    public void addProductShape(ProductShape productShape) {
//        this.productShapes.add(productShape);
//    }

//    public void addProductSize(ProductSize productSize) {
//        this.productSizes.add(productSize);
//    }
//
//    public void addProductSpec(ProductSpec productSpec) {
//        this.productSpecs.add(productSpec);
//    }

//    public void addProductColor(ProductColor productColor) {
//        this.productColors.add(productColor);
//    }
//
//
//    public void removeProductShape(ProductShape productShape) {
//        this.productShapes.remove(productShape);
//    }
//
//    public void removeProductSize(ProductSize productSize) {
//        this.productSizes.remove(productSize);
//    }

//    public void removeProductSpec(ProductSpec productSpec) {
//        this.productSpecs.remove(productSpec);
//    }


}
