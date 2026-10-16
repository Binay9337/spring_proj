package com.quickCommerce.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
       @NotBlank(message = "full name is required") @Size(min = 3, max = 100,message = "size must be between 3 to 100 ch") String fullName,

       @NotBlank(message = "Email is required")
       @Email(message = "invalid email format")
       String userEmail,

       @NotBlank(message = "password is required")
               @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+=^])(?=\\\\S+$).{8,20}$",  message = "Password must be 8–20 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character (no spaces)")
       String userPassword,

       @NotBlank(message = "phone number is required")
       @Pattern(regexp = "^[6-9][0-9]{9}$")
       String phoneNumber

) {
}
