package com.example.service;

import com.example.dto.OrderDto;
import com.example.model.Address;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.OrderStatus;
import com.example.model.User;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final AddressService addressService;
    private final OrderItemService orderItemService;

    public Order create(OrderDto orderDto, User user) {
        Optional<Address> address = addressService.fetchRightAddress(user.getId());
        address.orElseThrow();

        Order order = Order.builder()
                .address(address.get())
                .status(OrderStatus.INITIALIZATION)
                .user(user)
                .build();
        orderRepository.save(order); //TODO: transaction config

        List<OrderItem> orderItems = orderItemService.create(orderDto.getOrderItemDtos(), order);
        order.setOrderItems(orderItems);
        order.setStatus(OrderStatus.PENDING);

        return orderRepository.save(order);
    }
}
