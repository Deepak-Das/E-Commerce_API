package com.example.ecommerce.model;

import com.example.ecommerce.model.Product_models.Product;
import com.example.ecommerce.model.Product_models.ProductReview;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column(length = 50)
    private String email;
    @Column(length = 20)
    private String fullName;
    @Column(length = 10)
    private String role;
    @Column(length = 25)
    private String password;

    @Column(unique = true)
    private long phone;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Address> addresses=new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Product> products=new HashSet<>();

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<ProductReview> productReviews=new HashSet<>();


}
