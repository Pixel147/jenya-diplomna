package com.project.spring.controller;

import com.project.spring.converter.CategoryConverter;
import com.project.spring.dto.category.CategoryRequest;
import com.project.spring.dto.category.CategoryResponse;
import com.project.spring.entity.Category;
import com.project.spring.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<Category, Long, CategoryRequest, CategoryResponse> {
    private final CategoryService categoryService;
    private final CategoryConverter categoryConverter;

    public CategoryController(CategoryService categoryService, CategoryConverter categoryConverter) {
        this.categoryService = categoryService;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public CategoryService getService() {
        return categoryService;
    }

    @Override
    public CategoryConverter getConverter() {
        return categoryConverter;
    }
}
