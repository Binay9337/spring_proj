package com.quickCommerce.backend.dto.request;

import jakarta.validation.constraints.*;

public record ItemRequest(
        @NotBlank(message = "item name is required") @Size(min = 3, max = 150, message = "item name should be between 3 to 150") String itemName,

        @NotBlank @Size(max = 500, message = "desc must not exceed 500 character") String itemDescription,

        @NotNull(message = "price is required") @DecimalMin(value = "0.01", message = "price must be greater than 0.01") Double itemPrice,

        @Min(value = 0, message = "quantity cant be negative") int availableQuantity,

        @NotBlank(message = "category is required") @NotNull(message = "category is required") String categoryId,

        Boolean active) {
}
