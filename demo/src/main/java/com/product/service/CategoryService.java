package com.product.service;

import com.product.Exception.CategoryAlreadyExists;
import com.product.dto.CategoryDTO;
import com.product.entity.Category;
import com.product.mapper.CategoryMapper;
import com.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Optional<Category> byName = categoryRepository.findByName(categoryDTO.getName());

        if (byName.isPresent()) {
            throw new CategoryAlreadyExists("category " +categoryDTO.getName()+ " is already available");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);

        return CategoryMapper.toCategoryDTO(category);
    }

    //    get All category
    public List<CategoryDTO>  getAllCategory(){
       return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    //     get product by id

    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("no category found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    //    delete product by id

    public String deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
        return  "removed "+id+" successfully";
    }
}
