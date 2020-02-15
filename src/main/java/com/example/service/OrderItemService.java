package com.example.service;

import com.example.dto.OrderItemDto;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    public OrderItem create(OrderItemDto orderItemDto, Order order) {
        OrderItem orderItem = OrderItem.builder()
                .product(productService.findById(orderItemDto.getProductId()))
                .count(orderItemDto.getCount())
                .order(order)
                .build();
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> create(List<OrderItemDto> orderItemDtos, Order order) {
        ArrayList<OrderItem> result = new ArrayList<>();
        orderItemDtos.forEach(orderItemDto -> {
            result.add(create(orderItemDto, order));
        });
        return result;
    }
}
