package com.development.webfluxproject.adapter.mongo;


import com.development.webfluxproject.adapter.mongo.document.UserDocument;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReactiveMongoUserRepository extends ReactiveMongoRepository<UserDocument, String> {
   @Query("{ 'name':  { $regex:  ?0, $options:  'i' } }") //Case-insensitive
   Flux<UserDocument> findByName(String name, Pageable pageable);
}
