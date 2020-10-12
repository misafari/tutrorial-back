package com.safari.profile.model.post;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveSortingRepository<Post, String> {
    Flux<Post> findAllByAuthorIdOrderByPublishAsc(String authorId);
//    Flux<Post> findAllByIdNotNull(Sort sort, Pageable pageable);
}
