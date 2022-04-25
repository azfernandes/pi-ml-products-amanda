package com.piml.products.service;

import com.piml.products.dto.ProductDTO;
import com.piml.products.dto.ProductMapper;
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

    public ProductDTO create(Product product) {
        Product savedProduct = productRepository.save(product);
        return ProductMapper.INSTANCE.productToProductDTO(savedProduct);
    }
}
