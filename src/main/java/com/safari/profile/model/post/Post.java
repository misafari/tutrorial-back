package com.safari.profile.model.post;

import com.safari.profile.model.profile.Profile;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private String subject;
    private String content;
    private List<String> tags;
    private List<String> references;
    private LocalDateTime publish;
    private String authorId;
}
