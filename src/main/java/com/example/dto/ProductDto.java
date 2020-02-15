package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {
    private String sku;
    private BigDecimal price;
    private String description;
}
