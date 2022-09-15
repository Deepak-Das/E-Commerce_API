package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.UserDto;

public interface UserService {
   public UserDto creatUser(UserDto userDto);
   public UserDto updateUser(UserDto userDto,Long userId);
   public UserDto blockUser(Long userId);
}
