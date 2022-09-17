package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.payload.AddressDto;
import com.example.ecommerce.service.AddressService;

import java.util.Set;

public class AddressServiceImp implements AddressService {
    @Override
    public AddressDto createAddress(AddressDto addressDto, Long UserId) {
        return null;
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, Long UserId, Long addressId) {
        return null;
    }

    @Override
    public void deleteAddress(Long addressId) {

    }

    @Override
    public AddressDto getAddressById(Long addressId) {
        return null;
    }

    @Override
    public AddressDto getUserAddressByDefault(Long userId) {
        return null;
    }

    @Override
    public Set<AddressDto> getAllAddressByUser(Long userId) {
        return null;
    }
}
