package com.example.ecommerce.payload.category;

import com.example.ecommerce.util.ResponseView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class MainCategoryDto {

    private Long mainId;
    private String mainCategory;


    private Set<SubCategoryDto> subCategories = new HashSet<>();

}
