package com.quickCommerce.backend.service;

import com.quickCommerce.backend.dto.request.RegisterRequest;
import com.quickCommerce.backend.dto.response.UserResponse;
import com.quickCommerce.backend.entity.User;
import com.quickCommerce.backend.exception.DuplicateEntryException;
import com.qcommerce.backend.mapper.UserMapper;
import com.quickCommerce.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public UserResponse registerUser(RegisterRequest request) {
        if(userRepository.existsByUserEmail(request.userEmail())){
            throw new DuplicateEntryException("Email already registered with us");
        }

        User user = UserMapper.toEntity(request, null);

        // Create empty cart when an user is registerd - Future Work

        User savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser);
    }
}