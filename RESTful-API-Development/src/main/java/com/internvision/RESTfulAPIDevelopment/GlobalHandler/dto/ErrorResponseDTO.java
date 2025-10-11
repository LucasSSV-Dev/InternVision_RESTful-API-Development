package com.internvision.RESTfulAPIDevelopment.GlobalHandler.dto;

import org.springframework.http.HttpStatus;

import java.util.List;


public record ErrorResponseDTO(int status, String message, List<FieldMessage> fieldErrors) {

    public static ErrorResponseDTO defaultResponse(String message){
        return new ErrorResponseDTO(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    public static ErrorResponseDTO userConflict(){
        return new ErrorResponseDTO(HttpStatus.CONFLICT.value(), "This User already exists", List.of());
    }



    @Override
    public String toString() {
        return "ErrorResponse {\n" +
                "  status: " +
                status +
                ",\n" +
                "  message: " +
                "'" + message + "'" +
                ",\n" +
                "  erros: " +
                fieldErrors +
                "\n}";
    }
}
