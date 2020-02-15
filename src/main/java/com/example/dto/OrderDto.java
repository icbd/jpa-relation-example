package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class OrderDto {
    private List<OrderItemDto> orderItemDtos = new ArrayList<>();
}
