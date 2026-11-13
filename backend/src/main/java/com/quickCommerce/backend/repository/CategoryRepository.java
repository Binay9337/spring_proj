package com.quickCommerce.backend.repository;

import com.quickCommerce.backend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
    boolean existsByCategoryNameIgnoreCase(String categoryName);
Page<Category> findAllByCategoryNameContainingIgnoreCase(String categoryName, Pageable pageable);
}
