package com.example.controller.api.v1;

import com.example.dto.OrderDto;
import com.example.model.Order;
import com.example.model.User;
import com.example.service.OrderService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controller.api.v1.ApiV1BaseControler.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    /**
     * POST: /orders?userId=:userId
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<Order> create(@RequestParam Long userId, @RequestBody OrderDto orderDto) {
        User user = userService.findById(userId);
        Order order = orderService.create(orderDto, user);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
