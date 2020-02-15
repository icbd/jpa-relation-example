package com.example.repository;

import com.example.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> getAddressByUserIdAndFavorite(Long userId, Boolean favorite);

    Optional<Address> getFirstByUserIdOrderByUpdatedAtDesc(Long userId);

    Page<Address> findAllByUserIdOrderByFavoriteDescUpdatedAtDesc(Long userId, Pageable pageable);
}
