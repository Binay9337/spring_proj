package com.quickCommerce.backend.mapper;

import com.quickCommerce.backend.dto.request.RegisterRequest;
import com.quickCommerce.backend.dto.response.UserResponse;
import com.quickCommerce.backend.entity.UserEntity;
import com.quickCommerce.backend.entity.helper.AddressInfo;
import com.quickCommerce.backend.entity.helper.ContactInfo;
import com.quickCommerce.backend.entity.helper.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    private UserMapper(){}

    public static UserEntity toEntity(RegisterRequest request, PasswordEncoder passwordEncoder) {
        return UserEntity.builder()
                .userEmail(request.userEmail())
                .userPassword(passwordEncoder.encode(request.userPassword()))
                .userRole(Role.USER)
                .profileImage(null)
                .enabled(true)
                .contactInfo(new ContactInfo(request.fullName(), request.phoneNumber()))
                .addressInfo(new AddressInfo("", "", "", ""))
                .build();
    }

    public static UserResponse toResponse(UserEntity user) {
        return new UserResponse(
                user.getUserId(),
                user.getUserEmail(),
                user.getUserRole(),
                user.getProfileImage(),
                user.isEnabled(),
                user.getContactInfo().getFullName(),
                user.getContactInfo().getPhoneNumber(),
                user.getAddressInfo().getAddress(),
                user.getAddressInfo().getCity(),
                user.getAddressInfo().getState(),
                user.getAddressInfo().getZipCode()
        );
    }
}