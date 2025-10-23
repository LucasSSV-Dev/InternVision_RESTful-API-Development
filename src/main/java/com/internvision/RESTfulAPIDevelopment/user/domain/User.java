package com.internvision.RESTfulAPIDevelopment.user.domain;

import com.internvision.RESTfulAPIDevelopment.user.application.api.dto.CreateOrUpdateUserDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "users")
public class User {


    @Id
    private String id;

    private String name;
    private LocalDate birthDate;
    private String email;
    private String password;
    private boolean active;
    private UserRoleEnum role;

    public User updateUser(String id, CreateOrUpdateUserDTO dto) {
        this.id = dto.id();
        this.name = dto.name();
        this.birthDate = dto.birthDate();
        this.email = dto.email();
        this.password = dto.password();
        this.active = true;
        this.role = dto.role();

        return this;
    }
}
