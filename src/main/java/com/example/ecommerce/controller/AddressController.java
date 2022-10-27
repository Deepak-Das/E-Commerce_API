package com.example.ecommerce.controller;

import com.example.ecommerce.payload.AddressDto;
import com.example.ecommerce.service.user_service.AddressService;
import com.example.ecommerce.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;


    @PostMapping("user/{userId}/address")
    public ResponseEntity<AddressDto> createAddress(@Valid  @RequestBody AddressDto addressDto, @PathVariable("userId") Long userId){
        AddressDto dto = addressService.createAddress(addressDto, userId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PutMapping("user/{userId}/address/{addressId}")
    public ResponseEntity<AddressDto> updateAddress(@Valid @RequestBody AddressDto addressDto,@PathVariable("userId") Long userId ,@PathVariable("addressId") Long addressId){
        AddressDto dto = addressService.updateAddress(addressDto, userId, addressId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("address/{addressId}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("addressId") Long addressId){
        AddressDto dto = addressService.getAddressById(addressId);
        return new ResponseEntity<>(dto,HttpStatus.FOUND);
    }
    @GetMapping("user/{userId}/address")
    public ResponseEntity<Set<AddressDto>> getAllAddressesByUser(@PathVariable("userId") Long userId){
        Set<AddressDto> allAddressByUser = addressService.getAllAddressByUser(userId);
        return new ResponseEntity<>(allAddressByUser,HttpStatus.FOUND);
    }


    @PostMapping("address/{addressId}/set_default")
    public ResponseEntity<ApiResponse> setAddressDefault(@PathVariable("addressId") Long addressId){
        //TODO:bug need to fix for single address
        ApiResponse apiResponse = addressService.changeAddressDefault(addressId);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @DeleteMapping("address/{addressId}")
    public ResponseEntity<ApiResponse> deleteAddress(@PathVariable("addressId") Long addressId){
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>(new ApiResponse("address deleted"),HttpStatus.OK);
    }

}
