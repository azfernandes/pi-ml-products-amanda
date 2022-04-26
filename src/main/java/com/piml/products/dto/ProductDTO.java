package com.piml.products.dto;

import com.piml.products.entity.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private String description;
    private Double minimumTemperature;
    private Double size;
    private Long sellerId;
    private String category;

    public Product map() {
        return Product.builder().name(this.name).description(this.description).minimumTemperature(this.minimumTemperature).size(this.size).sellerId(this.sellerId).category(this.category).build();
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", minimumTemperature=" + minimumTemperature +
                ", size=" + size +
                ", sellerId=" + sellerId +
                ", category='" + category + '\'' +
                '}';
    }
}
