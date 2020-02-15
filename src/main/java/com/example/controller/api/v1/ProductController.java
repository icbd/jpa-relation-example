package com.example.controller.api.v1;

import com.example.model.Product;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controller.api.v1.ApiV1BaseControler.BASE_URL;

@RestController("api.v1.ProductController")
@RequestMapping(BASE_URL + "/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * GET: /api/v1/products
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public Page<Product> index(@PageableDefault Pageable pageable) {
        return productService.findAll(pageable);
    }
}
