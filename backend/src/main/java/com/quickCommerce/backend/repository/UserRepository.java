package com.quickCommerce.backend.repository;

import com.quickCommerce.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUserEmail(String userEmail);
}