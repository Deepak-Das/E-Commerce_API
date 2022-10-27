package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.AddressDto;
import com.example.ecommerce.repository.AddressRepo;
import com.example.ecommerce.repository.UserRepo;
import com.example.ecommerce.service.user_service.AddressService;
import com.example.ecommerce.util.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImp implements AddressService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public AddressDto createAddress(AddressDto addressDto, Long userId) {
        System.out.println("called!!!!!!!!!!!!!");
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId.toString()));
        Address address = mapper.map(addressDto, Address.class);
        address.setUser(user);
        System.out.println(address.toString());
        System.out.println(user.toString());
        Address save = addressRepo.save(address);
        return mapper.map(save, AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, Long userId, Long addressId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId.toString()));
        Address address = addressRepo.findAddressByAddressIdAndUser(addressId, user).orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId.toString()));
        Address updateAddress = mapper.map(addressDto, Address.class);
        updateAddress.setAddressId(address.getAddressId());
        updateAddress.setUser(user);
        return mapper.map(updateAddress, AddressDto.class);
    }

    @Override
    public void deleteAddress(Long addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId.toString()));
        addressRepo.delete(address);
    }

    @Override
    public AddressDto getAddressById(Long addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId.toString()));
        return mapper.map(address, AddressDto.class);

    }

    @Override
    public AddressDto getUserAddressByDefault(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId.toString()));

        Address address=addressRepo.findAddressByUserAndType(user,true).orElseThrow(() -> new ResourceNotFoundException("Address","default","true"));
        System.out.println("address:"+address.getAddressId());
        AddressDto dto = mapper.map(address, AddressDto.class);
        dto.setUser(user);
        System.out.println("address:"+dto.getAddressId());

        return dto;
    }

    @Override
    public ApiResponse changeAddressDefault(Long addressId) {
//        Address address=addressRepo.findById(addressId);
        Address address = addressRepo.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "addressId", addressId.toString()));
        address.setType(true);



        AddressDto addressDto = this.getUserAddressByDefault(address.getUser().getUserId());
        addressDto.setType(false);
        Address addressDefault = mapper.map(addressDto, Address.class);
        addressRepo.saveAll(Arrays.asList(addressDefault, address));
        return new ApiResponse("Default addressed changed");

    }


    @Override
    public Set<AddressDto> getAllAddressByUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId.toString()));
        Set<AddressDto> addressDtos = user.getAddresses().stream().map(address -> mapper.map(address, AddressDto.class)).collect(Collectors.toSet());
        return addressDtos;
    }
}
