package lt.codeacademy.ebook.product.pojo;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID productId;
    private String name;
    private BigDecimal price;
    private int amount;

    @ManyToMany
    private Set<ProductCategory> productCategories;
}