package com.quickCommerce.backend.entity;

import com.quickCommerce.backend.entity.helper.AddressInfo;
import com.quickCommerce.backend.entity.helper.ContactInfo;
import com.quickCommerce.backend.entity.helper.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String userId;

    @Column(nullable = false,unique = true, length = 100)
    private String userEmail;

    @Column(nullable = false, length = 30)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role userRole;

    private String profileImage;

    @Column(nullable = false)
    private boolean enabled = true;

    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    private AddressInfo addressInfo;

}
