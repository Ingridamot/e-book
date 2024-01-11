package lt.codeacademy.ebook.mappers;

import lt.codeacademy.ebook.product.Product;
import lt.codeacademy.ebook.product.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );
    }
}

