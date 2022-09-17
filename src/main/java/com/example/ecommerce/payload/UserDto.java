package com.example.ecommerce.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

//    @JsonIgnore
    private Long userId;

    @NotEmpty(message = "Please provide valid email before proceed")
    @Email(message = "Email must has valid format")
    private String email;
    @NotEmpty(message = "full Name must be provided")
    private String fullName;
    @NotEmpty(message = "please provide role")
    private String role;

//    @NotEmpty(message = "must have value")
    private boolean isBlock;

    @NotEmpty(message = "password field can not be empty")
    @Pattern(
            regexp = "^(?=.*[0-9])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=.*[A-Z])"
                    + "(?=.*[a-z])"
                    + "(?=\\S+$).{8,20}$",
            message = "must have min 8 character with at least 1 upperCase,LowerCase,digits and special character like @,#,$,%,^,&,+,= "
    )
    private String password;

    @NotEmpty(message = "phone field can not be empty")
    @Pattern(regexp = "^[+]91\\d{10}", message = "you have provided invalid phone number")
    //Error in validation constraint
    private String phone;
}
