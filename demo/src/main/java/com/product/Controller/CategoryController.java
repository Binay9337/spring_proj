package com.product.Controller;

import com.product.Exception.CategoryAlreadyExists;
import com.product.dto.CategoryDTO;
import com.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    create category

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
//        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);  // this is used to retune status code which one is good practice
//        try {
//            CategoryDTO category = categoryService.createCategory(categoryDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(category);
//        }catch (CategoryAlreadyExists ex){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
//        }
          CategoryDTO category = categoryService.createCategory(categoryDTO);
          return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategory(){
       return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
       return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable Long id){
        return categoryService.deleteCategoryById(id);
    }
    }


