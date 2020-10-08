package com.safari.profile.model.post;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;


public interface PostRepository extends ReactiveMongoRepository<Post, String> {
    Flux<Post> findAllByAuthorId(@Param("authorId") String authorId);
}
