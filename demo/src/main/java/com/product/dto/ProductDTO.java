package com.product.dto;

import com.product.entity.Category;
import com.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long Id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
}

