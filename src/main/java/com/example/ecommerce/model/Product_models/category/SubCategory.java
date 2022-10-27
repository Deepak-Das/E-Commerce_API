package com.example.ecommerce.model.Product_models.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sub_category")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long subId;

    @Column(length = 20,nullable = false)
    private String subCategory;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "main_cat_id",nullable = false)
    private MainCategory mainCategory;

    @OneToMany(mappedBy = "subCategory",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<ChildCategory> childCategories = new HashSet<>();

}