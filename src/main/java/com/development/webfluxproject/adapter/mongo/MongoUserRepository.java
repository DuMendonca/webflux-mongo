package com.development.webfluxproject.adapter.mongo;

import com.development.webfluxproject.adapter.mongo.document.UserDocument;
import com.development.webfluxproject.domain.model.User;
import com.development.webfluxproject.domain.port.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MongoUserRepository implements UserRepository {

    private final ReactiveMongoUserRepository repository;

    public MongoUserRepository(ReactiveMongoUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<User> findByName(String name, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByName(name, pageable).map(UserDocument::toDomain);
    }

    @Override
    public Mono<User> save(User user) {
        return repository.save(UserDocument.fromDomain(user)).map(UserDocument::toDomain);
    }

    @Override
    public Mono<User> findById(String id) {
        return repository.findById(id).map(UserDocument::toDomain);
    }

    @Override
    public Flux<User> findAll() {
        return repository.findAll().map(UserDocument::toDomain);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
