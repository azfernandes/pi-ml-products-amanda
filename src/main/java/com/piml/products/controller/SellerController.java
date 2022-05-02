package com.piml.products.controller;

import com.piml.products.dto.SellerDTO;
import com.piml.products.dto.SellerResponseDTO;
import com.piml.products.service.SellerAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class SellerController {
    @Autowired
    private SellerAPIService sellerAPIService;

    @PostMapping("/seller/v1")
    public ResponseEntity<SellerResponseDTO> createSeller(@Valid @RequestBody SellerDTO seller) {
        SellerDTO createdSeller = sellerAPIService.create(seller);
        SellerResponseDTO returnSeller = SellerResponseDTO.map(createdSeller);
        return new ResponseEntity<SellerResponseDTO>(returnSeller, HttpStatus.CREATED);
    }

    @GetMapping("/seller/v1/{id}")
    public ResponseEntity<SellerDTO> getSellerById(@PathVariable Long id) {
        SellerDTO foundSeller = sellerAPIService.getById(id);
        return ResponseEntity.ok(foundSeller);
    }
}
