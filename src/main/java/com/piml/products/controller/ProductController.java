package com.piml.products.controller;

import com.piml.products.dto.ProductDTO;
import com.piml.products.dto.ProductMapper;
import com.piml.products.entity.Product;
import com.piml.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {
    public static final String baseUri = "/product";

    @Autowired
    private ProductService productService;

    @PostMapping(baseUri)
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        System.out.println(productDTO.toString());
        Product product = ProductMapper.INSTANCE.productDTOtoProduct(productDTO);
        ProductDTO createdProduct = productService.create(product);
        return new ResponseEntity<ProductDTO>(createdProduct, HttpStatus.CREATED);
    }
}
