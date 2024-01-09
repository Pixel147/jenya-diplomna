package com.project.spring.converter;

import com.project.spring.dto.category.CategoryRequest;
import com.project.spring.dto.category.CategoryResponse;
import com.project.spring.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryConverter extends BaseConverter<Category, CategoryRequest, CategoryResponse> {

    @Override
    public Category requestToEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    @Override
    public CategoryResponse entityToResponse(Category entity) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(entity.getId());
        categoryResponse.setName(entity.getName());
        return categoryResponse;
    }

    @Override
    public List<CategoryResponse> entityToResponse(List<Category> entity) {
        return entity.stream().map(this::entityToResponse).toList();
    }
}
