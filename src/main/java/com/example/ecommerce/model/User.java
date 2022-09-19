package com.example.ecommerce.model;

import com.example.ecommerce.model.Product_models.Cart;
import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.details.ProductReview;
import com.example.ecommerce.model.Product_models.orders.TbOrder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(length = 50)
    private String email;
    @Column(length = 20)
    private String fullName;
    @Column(length = 10)
    private String role;
    @Column(length = 20)
    private String password;
    @Column(nullable = false)
    private boolean isBlock;

    @Column(unique = true,length = 13)
    private String phone;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Address> addresses=new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Product> products=new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ProductReview> productReviews=new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<TbOrder> orders=new HashSet<>();

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cart_id")
    private Cart cart;




}
