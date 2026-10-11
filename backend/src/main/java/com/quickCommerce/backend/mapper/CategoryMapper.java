package com.quickCommerce.backend.mapper;

import com.quickCommerce.backend.dto.response.CategoryResponse;
import com.quickCommerce.backend.entity.Category;

public class CategoryMapper {

private CategoryMapper() {}

    //    Entity to DTO
    public static CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getCategoryImage(),
                category.getItem() == null ? 0 : category.getItem().size()
        );

        return response;
    }

}
