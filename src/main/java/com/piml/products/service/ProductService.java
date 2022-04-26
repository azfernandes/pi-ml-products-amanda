package com.piml.products.service;

import com.piml.products.entity.Product;
import com.piml.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}
