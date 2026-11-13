package com.product.dto;

import com.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import io.swagger.v3.oas.annotations.media.Schema;


import java.util.List;

//@Schema
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long Id;
    private String name;
    private List<ProductDTO> products;
}
