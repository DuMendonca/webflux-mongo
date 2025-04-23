package com.development.webfluxproject.adapter.api;

import com.development.webfluxproject.application.service.UserService;
import com.development.webfluxproject.domain.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "Users", description = "Users managements")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Find all users", description = "Searches all users in system.")
    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.findAll();
    }

    @Operation(summary = "Find user by id", description = "Searches users according identification number.")
    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return userService.findById(id);
    }

    @Operation(summary = "Find user by name", description = "Searches users with pagination according your name.")
    @GetMapping("/search")
    public Flux<User> getUsersByName(@RequestParam String name,
                                     @RequestParam(defaultValue = "0") int size,
                                     @RequestParam(defaultValue = "10") int page) {
        return userService.findByName(name, size, page);
    }

    @Operation(summary = "Create a new user", description = "Create a new user in system.")
    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @Operation(summary = "Delete user by id", description = "Delete users according identification number.")
    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }
}
