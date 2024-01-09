package com.project.spring.service;

import com.project.spring.entity.Category;
import com.project.spring.repository.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category,Long>{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }
}
