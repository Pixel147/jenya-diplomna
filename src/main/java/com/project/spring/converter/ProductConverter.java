package com.project.spring.converter;

import com.project.spring.dto.product.ProductRequest;
import com.project.spring.dto.product.ProductResponse;
import com.project.spring.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductConverter extends BaseConverter<Product, ProductRequest, ProductResponse>{
    private final CategoryConverter categoryConverter;
    @Override
    public Product requestToEntity(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setCount(productRequest.getCount());
        product.setPrice(productRequest.getPrice());
        return product;
    }

    @Override
    public ProductResponse entityToResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setCount(product.getCount());
        productResponse.setPrice(product.getPrice());
        productResponse.setCategory(categoryConverter.entityToResponse(product.getCategory()));
        return productResponse;
    }

    @Override
    public List<ProductResponse> entityToResponse(List<Product> entity) {
        return entity.stream().map(this::entityToResponse).toList();
    }

}
