package com.example.service;

import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product create(ProductDto productDto) {
        Product product = Product.builder()
                .sku(productDto.getSku())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
        return productRepository.save(product);
    }
}
