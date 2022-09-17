package com.example.ecommerce.service.serviceImp;

import com.example.ecommerce.exception.AlreadyExistException;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.User;
import com.example.ecommerce.payload.UserDto;
import com.example.ecommerce.repository.UserRepo;
import com.example.ecommerce.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDto creatUser(UserDto userDto) {
        boolean userExistWithEmail = userRepo.existsUserByEmail(userDto.getEmail());
        boolean userExistWithPhone = userRepo.existsUserByPhone(userDto.getPhone());

        if (userExistWithEmail) throw new AlreadyExistException("User", "email", userDto.getEmail());
        if (userExistWithPhone) throw new AlreadyExistException("User", "phone number", userDto.getPhone());

        User newUser =mapper.map(userDto,User.class);

        return mapper.map(userRepo.save(newUser),UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        boolean userExist = userRepo.existsById(userId);

        if (!userExist) throw new ResourceNotFoundException("User", "email", userDto.getEmail());

        User updatedUser=mapper.map(userDto,User.class);
        updatedUser.setUserId(userId);


        return mapper.map(userRepo.save(updatedUser),UserDto.class);
    }

    @Override
    public UserDto blockUser(Long userId) {
        boolean userExist = userRepo.existsById(userId);

        if (!userExist) throw new ResourceNotFoundException("User", "userId", userId.toString());

        User updatedUser=userRepo.findById(userId).get();
        updatedUser.setBlock(true);

        return mapper.map(userRepo.save(updatedUser),UserDto.class);
    }

    @Override
    public UserDto getUser(Long userId) {
        boolean userExist = userRepo.existsById(userId);
        if (!userExist) throw new ResourceNotFoundException("User", "userId", userId.toString());
        return mapper.map(userRepo.findById(userId),UserDto.class);
    }

    @Override
    public Set<UserDto> getAllUser() {
        Set<UserDto> urs = userRepo.findAll().stream().map(user -> mapper.map(user, UserDto.class)).collect(Collectors.toSet());
        return urs;
    }
}
