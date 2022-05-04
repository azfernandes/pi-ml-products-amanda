package com.piml.products.controller;

import com.piml.products.dto.ProductDTO;
import com.piml.products.entity.Product;
import com.piml.products.interfaces.CategoryENUM;
import com.piml.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/fresh-products")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO dto) {
        Product product = dto.map();
        ProductDTO createdProduct = ProductDTO.map(productService.create(product));
        return new ResponseEntity<ProductDTO>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/fresh-products/v1/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id){
        Product product = productService.getById(id);
        ProductDTO convertedProduct = ProductDTO.map(product);
        return ResponseEntity.ok(convertedProduct);
    }

    @GetMapping("/fresh-products/v1")
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(name = "products", required = false) List<Long> productIds)  {
        List<Product> productList = productService.getAllProducts(productIds);
        return ResponseEntity.ok(ProductDTO.map(productList));
    }

    @GetMapping("/fresh-products/v1/list")
    public ResponseEntity<List<ProductDTO>> getByCategory(@RequestParam(name = "category") CategoryENUM category) {
        List<Product> productList = productService.getByCategory(category);
        return ResponseEntity.ok(ProductDTO.map(productList));
    }

    @GetMapping("api/v1/fresh-products/price")
    public ResponseEntity<List<ProductDTO>> findByPriceLessThanEqual(@RequestParam(name = "price") BigDecimal price) {
        List<Product> productList = productService.findByPriceLessThanEqual(price);
        return ResponseEntity.ok(ProductDTO.map(productList));
    }
}

