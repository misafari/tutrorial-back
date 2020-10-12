package com.safari.profile.controller;

import com.safari.profile.model.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ZeroCopyHttpOutputMessage;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(path = "file")
@RequiredArgsConstructor
public class FileController {
    private final FileService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Void> save(@RequestPart("file") FilePart file) throws IOException {
        return service.save(file);
    }

    @GetMapping("/download")
    public Mono<Void> downloadByWriteWith(ServerHttpResponse response) {
        File file = new File("/home/safari/Download/Screenshot from 2020-09-02 11-21-47.png");

        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=parallel.png");
        response.getHeaders().setContentType(MediaType.IMAGE_PNG);

        return zeroCopyResponse.writeWith(file, 0, file.length());
    }
}
