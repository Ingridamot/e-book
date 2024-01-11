package lt.codeacademy.ebook.config;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.ebook.product.Product;
import lt.codeacademy.ebook.product.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class ProductDataMockConfig {

    private static final int MAX_COUNT = 10;

    private final ProductService productService;

    @Bean
    public Void initProducts() {
        log.atDebug().log("-==== initProducts initialization start ====-");
        var count = 0;
        final Faker faker = new Faker();
        while (MAX_COUNT >= count) {
            productService.saveProduct(
                    Product.builder()
                            .name("(faker) " + faker.food().fruit())
                            .amount(faker.number().numberBetween(2, 99))
                            .price(faker.number().numberBetween(1, 100))
                            .build());
            count++;
        }
        log.atDebug().log("-==== initProducts initialization end ====-");
        return null;
    }
}
