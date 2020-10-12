package com.safari.profile.model.file;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface FileRepository extends ReactiveSortingRepository<File, String> {
}
