package com.example.controller;

import com.example.model.Address;
import com.example.model.User;
import com.example.repository.AddressRepository;
import com.example.repository.UserRepository;
import com.example.service.AddressService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
