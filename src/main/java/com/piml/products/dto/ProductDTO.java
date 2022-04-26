package com.piml.products.dto;

import com.piml.products.entity.Product;
import com.piml.products.interfaces.CategoryENUM;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private String description;
    private Double minimumTemperature;
    private Double size;
    private Long sellerId;
    private BigDecimal price;
    private CategoryENUM category;

    public Product map() {
        return Product.builder().name(this.name)
                .description(this.description)
                .minimumTemperature(this.minimumTemperature)
                .size(this.size)
                .sellerId(this.sellerId)
                .price(this.price)
                .category(this.category.getCategoryDescription()).build();
    }

    public static ProductDTO map(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .minimumTemperature(product.getMinimumTemperature())
                .size(product.getSize())
                .sellerId(product.getSellerId())
                .price(product.getPrice())
                .category(CategoryENUM.convertToEnum(product.getCategory())).build();
    }

    public static List<ProductDTO> map(List<Product> productList) {
        return productList.stream().map(ProductDTO::map).collect(Collectors.toList());
    }

}
