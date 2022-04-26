package com.piml.products.entity;

import lombok.*;
import lombok.Builder;
import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;

    private String name;
    private String description;
    private Double minimumTemperature;
    private Double size;
    private Long sellerId;
    private String category;
}

