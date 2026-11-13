package com.product.mapper;

import com.product.dto.CategoryDTO;
import com.product.entity.Category;

public class CategoryMapper {


//    this is for DTO to entity
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
            Category category = new Category();
            category.setName(categoryDTO.getName());
        return category;
    }

// this is entity to dto
    public static CategoryDTO toCategoryDTO(Category category){
        if (category == null) {
            return  null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());  // try after sometime if we delete this things are same or not
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());

        return categoryDTO;
    }


}
