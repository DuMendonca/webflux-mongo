package com.development.webfluxproject.application.service;

import com.development.webfluxproject.domain.model.User;
import com.development.webfluxproject.domain.port.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findByName(String name, int size, int page) {
        return userRepository.findByName(name, size, page);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
