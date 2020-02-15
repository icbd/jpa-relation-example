package com.example.controller;

import com.example.dto.AddressDto;
import com.example.dto.OrderDto;
import com.example.dto.UserDto;
import com.example.model.Address;
import com.example.model.Order;
import com.example.model.User;
import com.example.service.AddressService;
import com.example.service.OrderService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final OrderService orderService;
    private final AddressService addressService;

    /**
     * GET: /users
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public Page<User> index(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return userService.findAll(pageable);
    }

    /**
     * GET: /users/:userId
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public User show(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    /**
     * POST: /users
     *
     * @param userDto
     * @return
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
        User user = userService.create(userDto);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    /**
     * PATCH: /users/:userId
     *
     * @param userId
     * @param userDto
     * @return
     */
    @PatchMapping("/{userId}")
    public User update(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return userService.update(userId, userDto);
    }

    /**
     * DELETE: /users/:userId
     *
     * @param userId
     */
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

//    public Page<Order> orderIndex(@PageableDefault Pageable pageable) {
//        OrderService
//    }

    /**
     * POST: /users/:userId/orders
     *
     * @return
     */
    @PostMapping("/{userId}/orders")
    public ResponseEntity<Order> createOrder(@PathVariable Long userId, @RequestBody OrderDto orderDto) {
        User user = userService.findById(userId);
        Order order = orderService.create(orderDto, user);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    /**
     * GET: /users/:userId/addresses
     *
     * @param userId
     * @param pageable
     * @return
     */
    @GetMapping("/{userId}/addresses")
    public Page<Address> addressIndex(@PathVariable Long userId, @PageableDefault Pageable pageable) {
        return addressService.findAllByUserIdOrderByFavoriteDescUpdatedAtDesc(userId, pageable);
    }

    /**
     * POST: /users/:userId/addresses
     *
     * @return
     */
    @PostMapping("/{userId}/addresses")
    public Address addressCreate(@PathVariable Long userId, @RequestBody AddressDto addressDto) {
        User user = userService.findById(userId);
        return addressService.create(addressDto, userId);
    }
}
