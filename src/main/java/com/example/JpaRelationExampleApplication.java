package com.example;

import com.example.model.Address;
import com.example.model.User;
import com.example.repository.AddressRepository;
import com.example.repository.UserRepository;
import com.example.service.AddressService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaRelationExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaRelationExampleApplication.class, args);
    }

}
