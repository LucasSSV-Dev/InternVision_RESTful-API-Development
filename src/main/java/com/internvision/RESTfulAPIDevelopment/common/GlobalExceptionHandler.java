package com.internvision.RESTfulAPIDevelopment.common;

import com.internvision.RESTfulAPIDevelopment.common.dto.ErrorResponseDTO;
import com.internvision.RESTfulAPIDevelopment.common.dto.FieldMessage;
import com.internvision.RESTfulAPIDevelopment.common.exception.EmailAlreadyUsedException;
import com.internvision.RESTfulAPIDevelopment.common.exception.UserNotFoundException;
import com.internvision.RESTfulAPIDevelopment.common.exception.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDTO handleNotKnownErrors() {
        return new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred. Please contact our support.",
                List.of()
        );
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleWrongPassword(WrongPasswordException exception) {
        return new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                List.of()
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNotFound(UserNotFoundException exception) {
        return new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                List.of()
        );
    }

    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ErrorResponseDTO handleEmailAlreadyUsedException() {
        return new ErrorResponseDTO(HttpStatus.CONFLICT.value(),
                "This email is already used.",
                List.of()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        //Selecionando apenas o que precisamos da Exception
        List<FieldError> fieldErrors = exception.getFieldErrors();
        // Transformando cada erro em um ErroCampo e criando uma lista deles.
        List<FieldMessage> fieldMessageList = fieldErrors.stream()
                .map(fieldError -> new FieldMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();
        return new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Validation error",
                fieldMessageList
        );
    }



}
