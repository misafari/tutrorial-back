package com.safari.profile.controller;

import com.safari.profile.model.post.Post;
import com.safari.profile.model.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "post")
@RequiredArgsConstructor
@CrossOrigin
public class PostController {
    private final PostRepository repository;

    @PostMapping
    public @ResponseBody
    Mono<Post> save(@RequestBody Post post) {
        return repository.save(post);
    }

//    @GetMapping("pageable")
//    public @ResponseBody
//    Flux<Post> getAllAsPageable(final @RequestParam(name = "page") int page,
//                      final @RequestParam(name = "size") int size) {
//        return repository.findAllByIdNotNull(Sort.by("publish").ascending(), PageRequest.of(page, size));
//    }

    @GetMapping
    public @ResponseBody
    Flux<Post> getAll() {
        return repository.findAll(Sort.by("publish").ascending());
    }

    @GetMapping("size")
    public @ResponseBody Mono<Long> getSize() {
        return repository.count();
    }

    @GetMapping("byAuthor/{authorId}")
    public @ResponseBody Flux<Post> getByAuthor(@PathVariable String authorId) {
        return repository.findAllByAuthorIdOrderByPublishAsc(authorId);
    }
}
