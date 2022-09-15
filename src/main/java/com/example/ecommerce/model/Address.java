package com.example.ecommerce.model;

import com.example.ecommerce.model.Product_models.orders.TbOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String detail;

    @Column(nullable = false)
    private long phone;


    @Column(nullable = false)
    private boolean isDefault;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "address",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<TbOrder> orders=new HashSet<>();




}
