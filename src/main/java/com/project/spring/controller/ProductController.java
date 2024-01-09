package com.project.spring.controller;

import com.project.spring.converter.BaseConverter;
import com.project.spring.converter.ProductConverter;
import com.project.spring.dto.product.ProductRequest;
import com.project.spring.dto.product.ProductResponse;
import com.project.spring.entity.Product;
import com.project.spring.service.BaseService;
import com.project.spring.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController<Product, Long, ProductRequest, ProductResponse> {
    private final ProductService productService;
    private final ProductConverter productConverter;

    public ProductController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProductResponse> save(ProductRequest productRequest) {
        Product entity = getConverter().requestToEntity(productRequest);
        entity = productService.save(entity, productRequest.getCategoryId());
        ProductResponse response = getConverter().entityToResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(Long id, ProductRequest productRequest) {
        Product entity = productService.findById(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        entity = getConverter().requestToEntity(productRequest);
        entity.setId(id);
        entity = productService.save(entity, productRequest.getCategoryId());
        ProductResponse response = getConverter().entityToResponse(entity);
        return ResponseEntity.ok(response);
    }

    @Override
    public BaseService<Product, Long> getService() {
        return productService;
    }

    @Override
    public BaseConverter<Product, ProductRequest, ProductResponse> getConverter() {
        return productConverter;
    }
}
