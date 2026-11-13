package com.quickCommerce.backend.entity.helper;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
//@MappedSuperclass use @Embeddable or this
public class ContactInfo {
    private String fullName;
    private String phoneNumber;
}
