package com.quickCommerce.backend.dto.response;


import com.quickCommerce.backend.entity.helper.Role;

public record UserResponse(String userId,
                           String userEmail,
                           Role userRole,
                           String profileImage,
                           boolean enabled,
//                           contact info
                           String fullName,
                           String phoneNumber,

//                           AddressInfo
                           String address,
                           String city,
                           String state,
                           String zipCode

) {
}
