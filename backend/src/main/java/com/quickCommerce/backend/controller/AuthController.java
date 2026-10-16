package com.quickCommerce.backend.controller;

import com.quickCommerce.backend.dto.request.LoginRequest;
import com.quickCommerce.backend.dto.request.RegisterRequest;
import com.quickCommerce.backend.dto.response.LoginResponse;
import com.quickCommerce.backend.dto.response.UserResponse;
import com.quickCommerce.backend.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody @Valid RegisterRequest request) {
        return authService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }

}