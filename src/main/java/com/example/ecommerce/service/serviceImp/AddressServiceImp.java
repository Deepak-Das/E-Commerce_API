package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.AddressDto;
import com.example.ecommerce.repository.AddressRepo;
import com.example.ecommerce.repository.UserRepo;
import com.example.ecommerce.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class AddressServiceImp implements AddressService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public AddressDto createAddress(AddressDto addressDto, Long userId) {
        User user=userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","userId",userId.toString()));
        Address address=mapper.map(addressDto,Address.class);
        address.setUser(user);
        return mapper.map(addressRepo.save(address),AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, Long userId, Long addressId) {
        User user=userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","userId",userId.toString()));
        Address address=addressRepo.findAddressByAddressIdAndUser(addressId,user).orElseThrow(() -> new ResourceNotFoundException("Address","addressId",addressId.toString()));
        Address updateAddress=mapper.map(addressDto,Address.class);
        updateAddress.setAddressId(addressId);
        updateAddress.setUser(user);
        return mapper.map(updateAddress,AddressDto.class);
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
