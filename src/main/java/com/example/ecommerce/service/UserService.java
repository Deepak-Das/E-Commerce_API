package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.UserDto;

import java.util.List;
import java.util.Set;

public interface UserService {
   public UserDto creatUser(UserDto userDto);
   public UserDto updateUser(UserDto userDto,Long userId);
   public UserDto blockUser(Long userId);

   public UserDto getUser(Long userId);
   public Set<UserDto> getAllUser();

//   public UserDto getAddressByUser(Long userId);
}
