package com.internvision.RESTfulAPIDevelopment.user.application.api.dto;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequestDTO(
        @NotBlank(message = "Old password is required")
        String oldPassword,
        @NotBlank(message = "New password is required")
        String newPassword) {
}
