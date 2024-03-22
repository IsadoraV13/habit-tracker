package com.isadora.habittracker.controller;

import com.isadora.habittracker.domain.EntityNotFound;
import com.isadora.habittracker.domain.User;
import com.isadora.habittracker.domain.UserResponse;
import com.isadora.habittracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> viewAllUsers() {
        return userService.listAllUsers();
    }

    @GetMapping("/active")
    public List<User> viewAllActiveUsers() {
        return userService.listAllActiveUsers();
    }

    @GetMapping("/inactive")
    public List<User> viewAllInactiveUsers() {
        return userService.listAllInactiveUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> viewUserById(@PathVariable int userId) {
        var someUser = userService.listUserById(userId);
        if (someUser.isPresent()) {
            return ResponseEntity.ok(UserResponse.of(someUser.get()));
        }
        throw new EntityNotFound();
    }
}
