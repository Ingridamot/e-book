package lt.codeacademy.ebook.product;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private UUID productId;
    private String name;
    private double price;
    private int amount;
}


