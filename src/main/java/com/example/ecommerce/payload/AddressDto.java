package com.example.ecommerce.payload;

import com.example.ecommerce.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {

//    @JsonIgnore
    private Long addressId;
    @NotEmpty(message = "please provide full name")
    @Size(max=20)
    private String fullName;
    @NotEmpty(message = "please provide house")
    @Size(max=20)
    private String house;
    @NotEmpty(message = "please provide village/Town")
    @Size(max=20)
    private String village_Town;
    @NotEmpty(message = "please provide street")
    @Size(max=20)
    private String street;
    @NotEmpty(message = "please provide state")
    @Size(max=20)
    private String state;
    @Pattern(regexp = "^\\d{6,}$",message = "you have provided invalid phone number")
    private String pin;
    @NotEmpty(message = "please provide land mark")
    @Size(max=20)
    private String landMark;
    @Pattern(regexp = "^[+]91\\d{10}", message = "you have provided invalid phone number")
    private String phone;
    private boolean type;

    @JsonIgnore
    private User user;

}
