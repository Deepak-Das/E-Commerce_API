package com.example.ecommerce.repository;

import com.example.ecommerce.model.Address;
import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByPhone(String phone);
    boolean existsUserByEmail(String email);

    boolean existsUserByPhone(String phoneNo);
//    boolean existsUserByEmailAndOrPhone(String email ,String phone);

    boolean existsUserByUserIdAndEmail(Long userId,String email);
    boolean existsUserByUserIdAndPhone(Long userId,String Phone);






}
