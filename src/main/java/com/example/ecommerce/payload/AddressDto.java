package com.example.ecommerce.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class AddressDto {

//    @JsonIgnore
    private Long addressId;

    private String fullName;
    private String house;
    private String village_Town;
    private String Street;
    private String state;
    private Integer pin;
    private String landMark;
    private String phone;
    private boolean isDefault;

}
