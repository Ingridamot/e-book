package lt.codeacademy.ebook.product.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.ebook.product.dao.ProductCategoryRepository;
import lt.codeacademy.ebook.product.dto.ProductCategoryDto;
import lt.codeacademy.ebook.product.mappers.ProductCategoryMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    public Set<ProductCategoryDto> getCategories() {
        return productCategoryRepository.findAll().stream()
                .map(productCategoryMapper::toDto)
                .collect(Collectors.toSet());
    }

}

