package com.safari.profile.model.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    private String name;
    private String surname;
    private String mobile;
    private String email;
    private String aboutMe;
    private String avatar;
}
