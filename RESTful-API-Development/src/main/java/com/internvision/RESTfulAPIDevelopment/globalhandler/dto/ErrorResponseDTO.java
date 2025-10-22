package com.internvision.RESTfulAPIDevelopment.globalhandler.dto;

import org.springframework.http.HttpStatus;

import java.util.List;


public record ErrorResponseDTO(int status, String message, List<FieldMessage> fieldErrors) {

    public static ErrorResponseDTO userConflict(){
        return new ErrorResponseDTO(HttpStatus.CONFLICT.value(), "This email is already used.", List.of());
    }

}
