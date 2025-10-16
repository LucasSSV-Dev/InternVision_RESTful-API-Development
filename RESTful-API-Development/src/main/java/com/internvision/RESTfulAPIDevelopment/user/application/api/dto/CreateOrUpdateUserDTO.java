package com.internvision.RESTfulAPIDevelopment.user.application.api.dto;

import com.internvision.RESTfulAPIDevelopment.user.domain.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateOrUpdateUserDTO(
        String id,

        @NotBlank(message = "Campo Obrigatório!")
        @Size(min = 2, max = 100, message = "Limite de caracteres ultrapassado. Max: 100.")
        String name,

        @NotNull(message = "Campo Obrigatório!")
        LocalDate birthDate,

        @Email(message = "Insira um email válido.")
        @NotBlank(message = "Insira um email válido.")
        String email,

        @NotBlank(message = "Digite uma senha!")
        @Size(min = 8, max = 64, message = "A senha precisa ter entre 8 e 64 caracteres.")
        String password,

        @NotNull(message = "Função inválida!")
        UserRoleEnum role
) {
}
