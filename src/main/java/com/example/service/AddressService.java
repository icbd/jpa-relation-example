package com.example.service;

import com.example.dto.AddressDto;
import com.example.model.Address;
import com.example.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * 优先取有favorite标记的地址, 如果没有就取最近编辑的一个地址
     *
     * @param userId
     * @return
     */
    public Optional<Address> fetchRightAddress(Long userId) {
        return addressRepository.findFirstByUserIdOrderByFavoriteDescUpdatedAtDesc(userId);
    }

    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
