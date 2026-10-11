

package com.quickCommerce.backend.entity.helper;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
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
public class AddressInfo {

    private String address;

    private String city;

    private String state;

    private String zipCode;
}
