package com.development.webfluxproject.domain.port;

import com.development.webfluxproject.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Flux<User> findByName(String name, int size, int page);
    Mono<User> save(User user);
    Mono<User> findById(String id);
    Flux<User> findAll();
    Mono<Void> deleteById(String id);
}
