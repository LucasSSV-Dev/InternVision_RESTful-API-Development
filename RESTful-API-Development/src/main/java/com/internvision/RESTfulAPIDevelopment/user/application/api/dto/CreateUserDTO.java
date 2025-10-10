package com.internvision.RESTfulAPIDevelopment.user.application.api.dto;

import com.internvision.RESTfulAPIDevelopment.user.domain.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateUserDTO(
        @NotBlank(message = "Campo Obrigatório!")
        @Size(min = 2, max = 100, message = "Limite de caracteres ultrapassado. Max: 100.")
        String name,

        @NotNull(message = "Campo Obrigatório!")
        LocalDate birthDate,

        @Email(message = "Insira um email válido")
        @NotBlank
        String email,

        @NotBlank
        @Size(min = 8, max = 64, message = "Limite de caracteres ultrapassado. Max: 64.")
        String password,

        @NotNull
        UserRoleEnum role
) {
}
