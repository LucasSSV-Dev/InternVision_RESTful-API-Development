package com.internvision.RESTfulAPIDevelopment.user.application.api.dto;

import com.internvision.RESTfulAPIDevelopment.user.domain.User;
import com.internvision.RESTfulAPIDevelopment.user.domain.UserRoleEnum;

import java.time.LocalDate;

public record CreateUserDTO(
        String name,
        LocalDate birthDate,
        String email,
        String password,
        UserRoleEnum role
) {
}
