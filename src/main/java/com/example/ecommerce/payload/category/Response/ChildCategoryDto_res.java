package com.example.ecommerce.payload.category;

import com.example.ecommerce.util.ResponseView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
public class ChildCategoryDto {
    private Long childId;

    private String childCategory;

}