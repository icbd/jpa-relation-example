package com.example.service;

import com.example.dto.AddressDto;
import com.example.model.Address;
import com.example.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address create(AddressDto addressDto, Long userId) {
        Address address = Address.builder()
                .location(addressDto.getLocation())
                .phoneNumber(addressDto.getPhoneNumber())
                .userId(userId)
                .favorite(addressDto.getFavorite())
                .build();
        return addressRepository.save(address);
    }

    public Page<Address> findAllByUserIdOrderByFavoriteDescUpdatedAtDesc(Long userId, Pageable pageable) {
        return addressRepository.findAllByUserIdOrderByFavoriteDescUpdatedAtDesc(userId, pageable);
    }

    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
