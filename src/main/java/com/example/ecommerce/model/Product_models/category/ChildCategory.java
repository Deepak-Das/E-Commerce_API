package com.example.ecommerce.model.Product_models.category;

import com.example.ecommerce.model.Product_models.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "child_category")
public class ChildCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long childId;

    @Column(length = 10,nullable = false)
    private String childCategory;


    @ManyToOne
    @JoinColumn(name = "subId")
    private SubCategory subCategory;

    @OneToMany(mappedBy = "childCategory", orphanRemoval = true)
    private Set<Product> products = new LinkedHashSet<>();

}