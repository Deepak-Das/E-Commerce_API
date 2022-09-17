package com.example.ecommerce.service;

import com.example.ecommerce.payload.AddressDto;

import java.util.Optional;
import java.util.Set;


public interface AddressService {
    public AddressDto createAddress(AddressDto addressDto,Long userId);
    public AddressDto updateAddress(AddressDto addressDto, Long userId , Long addressId);
    public void deleteAddress(Long addressId);


    public AddressDto getAddressById(Long addressId);
    public AddressDto getUserAddressByDefault(Long userId);
    public Set<AddressDto> getAllAddressByUser(Long userId);
}
