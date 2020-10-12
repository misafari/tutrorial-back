package com.safari.profile.model.file;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Document
@Setter
@Getter
@NoArgsConstructor
public class File {
    @MongoId(FieldType.STRING)
    private String id;
    private String subject;
    private String address;
    private String contentType;

    public File(Path path) throws IOException {
        address = path.toAbsolutePath().toString();
        contentType = Files.probeContentType(path);
    }

}
