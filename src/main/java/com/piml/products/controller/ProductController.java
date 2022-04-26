package com.piml.products.controller;

import com.piml.products.dto.ProductDTO;
import com.piml.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class ProductController {
    public static final String baseUri = "/product";

    @Autowired
    private ProductService productService;

    @PostMapping(baseUri)
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        System.out.println(productDTO.toString());
        //ProductDTO createdProduct = productService.create(product);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.CREATED);
    }
}
