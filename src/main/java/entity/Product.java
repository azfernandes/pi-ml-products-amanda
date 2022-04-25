package entity;

import lombok.*;

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
    @Column(name = "productId")
    private long id;

    private String name;
    private String description;
    private Double minimumTemperature;
    private Double size;
    private Long sellerId;
    private String category;
}

