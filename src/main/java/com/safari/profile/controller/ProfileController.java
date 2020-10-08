package com.safari.profile.controller;

import com.safari.profile.model.profile.Profile;
import com.safari.profile.model.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "profile")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {
    private final ProfileRepository repository;

    @PostMapping
    public @ResponseBody
    Mono<Profile> save(@Valid @RequestBody Profile profile) {
        return repository.save(profile);
    }

    @GetMapping
    public @ResponseBody
    Flux<Profile> getAll() {
        return repository.findAll();
    }

    @GetMapping("byId/{id}")
    public @ResponseBody
    Mono<Profile> getById(@PathVariable String id) {
        return repository.findById(id);
    }
}