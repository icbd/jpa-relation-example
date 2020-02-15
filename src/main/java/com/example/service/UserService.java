package com.example.service;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AddressService addressService;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User create(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
        return userRepository.save(user);
    }

    public User update(Long id, UserDto userDto) {
        Optional<User> user = userRepository.findById(id);

        return user.map(u -> {
            if (userDto.getName() != null) {
                u.setName(userDto.getName());
            }
            if (userDto.getEmail() != null) {
                u.setEmail(userDto.getEmail());
            }
            return userRepository.save(u);
        }).orElseThrow();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
