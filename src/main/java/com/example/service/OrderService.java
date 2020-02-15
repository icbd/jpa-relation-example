package com.example.service;

import com.example.dto.OrderDto;
import com.example.model.Address;
import com.example.model.Order;
import com.example.model.OrderStatus;
import com.example.model.User;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;

    public Order create(OrderDto orderDto, User user) {
        Optional<Address> address = userService.fetchRightAddress(user.getId());
        address.orElseThrow();

        Order order = Order.builder()
                .address(address.get())
                .status(OrderStatus.PENDING)
                .user(user)
                .build();
        return orderRepository.save(order);
    }
}
