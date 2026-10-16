package com.quickCommerce.backend.security;

import com.quickCommerce.backend.entity.UserEntity;
import com.quickCommerce.backend.exception.ResourceNotFound;
import com.quickCommerce.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserEmail(email)
                .orElseThrow(() -> new ResourceNotFound("Email not Found"));

        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userEntity.getUserRole().name());

        return User.builder()
                .username(userEntity.getUserEmail())
                .password(userEntity.getUserPassword())
                .disabled(!userEntity.isEnabled())
                .roles(authority.getAuthority())
                .build();
    }
}