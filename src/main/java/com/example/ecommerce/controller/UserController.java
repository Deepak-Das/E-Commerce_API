package com.example.ecommerce.controller;

import com.example.ecommerce.payload.UserDto;
import com.example.ecommerce.service.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<UserDto> creatNewUser(@Valid @RequestBody UserDto userDto){
        UserDto dto = service.creatUser(userDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED) ;
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") Long userId,@Valid @RequestBody UserDto userDto){
        UserDto dto = service.updateUser(userDto, userId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> userById(@PathVariable("userId") Long userId){
        UserDto dto = service.getUser(userId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED) ;
    }
    @GetMapping("/user")
    public ResponseEntity<Set<UserDto>> allUser(){
        Set<UserDto> dtos = service.getAllUser();
        return new ResponseEntity<>(dtos, HttpStatus.CREATED) ;
    }
}
