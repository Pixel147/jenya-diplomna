package com.project.spring.dto.product;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Long count;
    private Long price;
    private Long categoryId;
}
