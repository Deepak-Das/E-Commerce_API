package com.example.ecommerce.model.Product_models.category;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "main_category")
@Setter
@Getter
@NoArgsConstructor
public class MainCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long mainId;

    @Column(length = 20,nullable = false)
    private String mainCategory;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mainCategory",cascade = CascadeType.ALL)
    private Set<SubCategory> subCategories = new HashSet<>();




}
