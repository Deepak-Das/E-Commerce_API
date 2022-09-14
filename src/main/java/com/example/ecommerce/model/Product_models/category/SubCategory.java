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
    @ManyToOne
    @JoinColumn(name = "main_cat_id")
    private MainCategory mainCategory;

    @OneToMany(mappedBy = "subCategory",fetch = FetchType.EAGER)
    private Set<ChildCategory> subCategories = new HashSet<>();

}