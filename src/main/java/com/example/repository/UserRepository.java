package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByEmail(String name);
//
//    Integer countByAddress_LocationContains(String location);
//
//    List<User> findByAddress_LocationContains(String location);
}
