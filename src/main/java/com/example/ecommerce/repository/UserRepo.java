package com.example.ecommerce.repository;

import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    boolean existsUserByEmail(String email);

}
