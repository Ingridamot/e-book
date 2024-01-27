package lt.codeacademy.ebook.product.service;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.ebook.product.mappers.ProductMapper;
import lt.codeacademy.ebook.product.dao.ProductCategoryRepository;
import lt.codeacademy.ebook.product.dao.ProductDao;
import lt.codeacademy.ebook.product.dto.ProductDto;
import lt.codeacademy.ebook.product.exception.ProductNotFoundException;
import lt.codeacademy.ebook.product.pojo.Product;
import lt.codeacademy.ebook.product.pojo.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductMapper mapper;

    @Transactional
    public void saveProduct(ProductDto productDto) {
        final Product product = mapper.fromDto(productDto);
        final ProductCategory productCategory = productCategoryRepository.getReferenceById(productDto.getCategoryId());

        product.getProductCategories().add(productCategory);

        productDao.save(product);
    }

    public void updateProduct(ProductDto productDto) {
        productDao.update(mapper.fromDto(productDto));
    }

    public Page<ProductDto> getAllProductsPage(Pageable pageable) {
        return productDao.getPage(pageable).map(product -> mapper.toDto(product));
    }

    public ProductDto getProductByUUID(UUID id) {
        return productDao.getProductByUUID(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public void deleteProductByUUID(UUID id) {
        productDao.deleteProductByUUID(id);
    }
}
