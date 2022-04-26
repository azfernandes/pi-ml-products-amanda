package com.piml.products.entity;

import com.piml.products.interfaces.CategoryENUM;
import lombok.*;
import lombok.Builder;
import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
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
    private BigDecimal price;
    private Long sellerId;
    private String category;
}

