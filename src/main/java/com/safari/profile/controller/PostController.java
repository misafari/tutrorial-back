package com.safari.profile.controller;

import com.safari.profile.model.post.Post;
import com.safari.profile.model.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "post")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository repository;

    @PostMapping
    public @ResponseBody
    Mono<Post> save(@RequestBody Post post) {
        return repository.save(post);
    }

    @GetMapping
    public @ResponseBody
    Flux<Post> getAll() {
        return repository.findAll(Sort.by("publish").ascending());
    }

    @GetMapping("byAuthor/{authorId}")
    public @ResponseBody Flux<Post> getByAuthor(@PathVariable String authorId) {
        return repository.findAllByAuthorId(authorId);
    }
}
