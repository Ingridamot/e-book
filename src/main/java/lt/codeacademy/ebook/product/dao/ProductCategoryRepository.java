package lt.codeacademy.ebook.product.dao;

import lt.codeacademy.ebook.product.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
