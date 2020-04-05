package com.example.webcrawler.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("users")
public class User {
    @Id
    private String id;
    private String email;
    private Boolean verified;
    private String firstName;
    private String lastName;
    private List<String> interests;
}
