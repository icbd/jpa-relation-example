package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String location;
    private String phoneNumber;
    private Boolean favorite;
}
