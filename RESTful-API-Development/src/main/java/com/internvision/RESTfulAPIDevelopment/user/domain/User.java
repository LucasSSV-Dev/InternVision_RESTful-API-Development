package com.internvision.RESTfulAPIDevelopment.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private LocalDate birthDate;
    private String email;
    private String password;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserRoleEnum role;

    public User(String name, LocalDate birthDate, String email, String password, UserRoleEnum role) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.role = role;

        this.active = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
