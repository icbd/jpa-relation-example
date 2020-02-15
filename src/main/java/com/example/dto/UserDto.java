package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;

    // create new address
    private AddressDto address;
}
