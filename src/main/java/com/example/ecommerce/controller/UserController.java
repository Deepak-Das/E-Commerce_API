package com.example.ecommerce.controller;

import com.example.ecommerce.payload.UserDto;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.util.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<UserDto> addNewUser(@Valid @RequestBody UserDto userDto){
        UserDto dto = service.creatUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED) ;
    }
}
