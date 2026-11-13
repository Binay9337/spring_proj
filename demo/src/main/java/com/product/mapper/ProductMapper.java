package com.product.mapper;

import com.product.dto.ProductDTO;
import com.product.entity.Category;
import com.product.entity.Product;

public class ProductMapper {

    //
    // .+entity to dto
    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory().getId());
    }

    // dto to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;
    }
}