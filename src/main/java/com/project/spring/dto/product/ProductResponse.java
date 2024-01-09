package com.project.spring.dto.product;

import com.project.spring.dto.category.CategoryResponse;
import lombok.Data;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private Long count;
    private Long price;
    private CategoryResponse category;
}
