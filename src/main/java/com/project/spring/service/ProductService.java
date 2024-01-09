package com.project.spring.service;

import com.project.spring.entity.Product;
import com.project.spring.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product,Long>{
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    public Product save(Product product, Long categoryId) {
        product.setCategory(categoryService.findById(categoryId));
        return productRepository.save(product);
    }
}
