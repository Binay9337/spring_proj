package com.quickCommerce.backend.service;

import com.quickCommerce.backend.dto.request.LoginRequest;
import com.quickCommerce.backend.dto.request.RegisterRequest;
import com.quickCommerce.backend.dto.response.LoginResponse;
import com.quickCommerce.backend.dto.response.UserResponse;
import com.quickCommerce.backend.entity.UserEntity;
import com.quickCommerce.backend.exception.DuplicateEntryException;
import com.quickCommerce.backend.exception.ResourceNotFound;
import com.quickCommerce.backend.mapper.UserMapper;
import com.quickCommerce.backend.repository.UserRepository;
import com.quickCommerce.backend.security.jwt.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserResponse registerUser(RegisterRequest request) {
        if(userRepository.existsByUserEmail(request.userEmail())){
            throw new DuplicateEntryException("Email already registered with us");
        }

        UserEntity user = UserMapper.toEntity(request, passwordEncoder);

        // Create empty cart when an user is registerd - Future Work

        UserEntity savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser);
    }

    public LoginResponse loginUser(LoginRequest loginRequest) {
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

        authenticationManager.authenticate(authentication);

        UserEntity userEntity = userRepository.findByUserEmail(loginRequest.email())
                .orElseThrow(() -> new ResourceNotFound("Email not Found"));

        // generate token
        String token = jwtService.generateToken(userEntity.getUserId(), userEntity.getUserRole().name());

        // return response
        return new LoginResponse(token);
    }
}