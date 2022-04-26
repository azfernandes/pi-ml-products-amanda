package com.piml.products.service;

import com.piml.products.entity.Product;
import com.piml.products.interfaces.CategoryENUM;
import com.piml.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Product getById(Long id) {
        Optional<Product> foundProduct = this.productRepository.findById(id);
        return foundProduct.orElse(new Product());
    }
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        if(productList == null) {
            return new ArrayList<Product>();
        }
        return productList;
    }
    public List<Product> getByCategory(CategoryENUM category) {
       return productRepository.findByCategory(category.getCategoryDescription());
    }
}
