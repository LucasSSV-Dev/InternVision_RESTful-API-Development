package com.internvision.RESTfulAPIDevelopment.globalhandler;

import com.internvision.RESTfulAPIDevelopment.globalhandler.dto.ErrorResponseDTO;
import com.internvision.RESTfulAPIDevelopment.globalhandler.dto.FieldMessage;
import com.internvision.RESTfulAPIDevelopment.globalhandler.exception.EmailAlreadyUsedException;
import com.internvision.RESTfulAPIDevelopment.globalhandler.exception.UserNotFoundException;
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

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNotFound() {
        return new ErrorResponseDTO(
                HttpStatus.NOT_FOUND.value(),
                "The requested resource was not found.",
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
