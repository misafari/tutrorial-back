package com.safari.profile.model.file;

import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository repository;
    private final String ROOT_DIRECTORY = "/home/safari/Downloads";

    public Mono<Void> save(FilePart fileParts) throws IOException {
        return Mono.fromRunnable(() -> initRootDirectory(ROOT_DIRECTORY))
                .publishOn(Schedulers.newBoundedElastic(1, 1, "initRootDirectory"))
                .then(saveFileToDiskAndUpdate(fileParts))
                .subscribeOn(Schedulers.boundedElastic());
    }

    private void initRootDirectory(String root) {
        File file = new File(root);
        file.mkdirs();
    }

    private Mono<Void> saveFileToDiskAndUpdate(final FilePart file) throws IOException {
        final Path path = Paths.get(ROOT_DIRECTORY, file.filename());
        return Mono.just(path)
                .flatMap(file::transferTo)
                .and(repository.save(new com.safari.profile.model.file.File(path)));
    }
}
