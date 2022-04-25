package com.piml.products.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("minimumTemperature")
    private Double minimumTemperature;
    @JsonProperty("size")
    private Double size;
    @JsonProperty("sellerId")
    private Long sellerId;
    @JsonProperty("category")
    private String category;

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
