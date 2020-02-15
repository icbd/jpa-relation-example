package com.example.controller.admin;

import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controller.admin.AdminBaseController.BASE_URL;

@RequestMapping(BASE_URL + "/products")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * POST: /admin/products
     *
     * @param productDto
     * @return
     */
    @PostMapping
    public Product create(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }
}
