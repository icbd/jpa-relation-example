package com.example.controller.api;

import com.example.repository.AddressRepository;
import com.example.repository.UserRepository;
import com.example.service.AddressService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WelcomeController {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserService userService;
    private final AddressService addressService;

    @GetMapping
    public String root() {
        return "<h1>HELLO!</h1>";
    }
}
