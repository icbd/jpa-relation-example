package com.example.controller.api.v1;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controller.api.v1.ApiV1BaseControler.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * GET: /api/v1/users
     *
     * @param pageable
     * @return
     */
    @GetMapping
    public Page<User> index(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return userService.findAll(pageable);
    }

    /**
     * GET: /api/v1/users/:userId
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public User show(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    /**
     * POST: /api/v1/users
     *
     * @param userDto
     * @return
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
        User user = userService.create(userDto);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    /**
     * PATCH: /api/v1/users/:userId
     *
     * @param userId
     * @param userDto
     * @return
     */
    @PatchMapping("/{userId}")
    public User update(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return userService.update(userId, userDto);
    }

    /**
     * DELETE: /api/v1/users/:userId
     *
     * @param userId
     */
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }
}
