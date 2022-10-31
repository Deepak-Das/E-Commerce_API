package com.example.ecommerce.model;

import com.example.ecommerce.model.Product_models.orders.TbOrder;
import lombok.Data;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(nullable = false,length = 20)
    private String fullName;
    @Column(nullable = false,length = 20)
    private String house;
    @Column(nullable = false,length = 20)
    private String village_Town;
    @Column(nullable = false,length = 20)
    private String Street;
    @Column(nullable = false,length = 20)
    private String state;
    @Column(nullable = false,length = 10)
    private String pin;
    @Column(nullable = false,length = 20)
    private String landMark;
    @Column(nullable = false,length = 13)
    private String phone;
    @Column(nullable = false)
    private boolean type;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "address",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<TbOrder> orders=new HashSet<>();




}
