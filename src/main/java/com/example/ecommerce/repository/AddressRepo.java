package com.example.ecommerce.repository;

import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.AddressDto;
import com.example.ecommerce.payload.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AddressRepo extends JpaRepository<Address,Long> {

    public Optional<Address> findAddressByAddressIdAndUser(Long addressId, User user);

    public Set<Address> findAddressByUser(User user);

    public Optional<Address> findAddressByUserAndType(User user,boolean def);




}
