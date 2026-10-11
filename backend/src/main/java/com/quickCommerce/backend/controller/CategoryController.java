package com.quickCommerce.backend.controller;

import com.quickCommerce.backend.constant.AppConstant;
import com.quickCommerce.backend.dto.request.CategoryRequest;
import com.quickCommerce.backend.dto.response.CategoryResponse;
import com.quickCommerce.backend.dto.response.PageResponse;
import com.quickCommerce.backend.entity.Category;
import com.quickCommerce.backend.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;
    @GetMapping
    public PageResponse<Category> getAllCategory(
            @RequestParam(
                    required = false,
                    defaultValue = AppConstant.DEFAULT_PAGE_SIZE
            ) int pageSize,

            @RequestParam(
                    required = false,
                    defaultValue = AppConstant.DEFAULT_PAGE_NUMBER
            ) int pageNumber,

            @RequestParam(required = false) String search
    ) {    return categoryService.getAllCategories(search,pageNumber,pageSize);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@RequestBody @Valid CategoryRequest categoryRequest, String search){
        return categoryService.createCategory(categoryRequest);
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CategoryResponse getCategory(@PathVariable String categoryId){
       return categoryService.getCategoryById(categoryId);
    }
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable String categoryId){
        categoryService.deleteCategoryById(categoryId);
    }
    @PutMapping("/{categoryId}")
    public CategoryResponse updateCategory(
            @PathVariable String categoryId,@RequestBody @Valid CategoryRequest categoryRequest){
        return categoryService.updateCategoryById(categoryId,categoryRequest);
    }
    @PostMapping("/{categoryId}/image")
    public CategoryResponse uploadImage(
            @PathVariable String categoryId,
            @RequestParam MultipartFile image){
        return categoryService.uploadCategoryImage(categoryId,image);
    }

}

/*
* @valid -->> this is used to run that @Size*/
