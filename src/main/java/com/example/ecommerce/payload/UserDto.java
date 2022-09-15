package com.example.ecommerce.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "Please provide valid email before proceed" )
    @Email(message = "Email must has valid format")
    private String email;
    @NotEmpty(message = "full Name must not be provided")
    private String fullName;
    @NotEmpty(message = "please provide role")
    private String role;
    @NotEmpty(message = "password field can not be empty")
    @Size(min=8,message = "password at least be of 8 digit")
    private String password;

    @Size(min=10,max = 10,message = "phone number must be of 10 digit")
    @NotEmpty(message = "phone field can not be empty")
    //Error in validation constraint
    private Long phone;
}
