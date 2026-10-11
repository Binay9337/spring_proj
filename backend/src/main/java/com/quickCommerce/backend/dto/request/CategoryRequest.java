package com.quickCommerce.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest( @Size(min = 3,max = 100,message = "category name must be between 3 to 100 ch") @NotBlank(message = "category name must not blank") String categoryName) {
}
/*
* @size --->> this annotation comes because of validation annotation and this use to give validation on sizes
* */