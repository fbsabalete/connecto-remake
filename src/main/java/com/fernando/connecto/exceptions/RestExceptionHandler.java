package com.fernando.connecto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public StandardError notFoundException (ObjectNotFoundException e){
        return new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjectAlreadyPresentException.class)
    public StandardError userAlreadyPresentException (ObjectAlreadyPresentException e){
        return new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationError> validationError(MethodArgumentNotValidException e){
        List<ValidationError> validationErrors = new ArrayList<>();
        e.getFieldErrors().forEach(resp -> {
            validationErrors.add(new ValidationError(resp.getField(), resp.getDefaultMessage()));
        });
        return validationErrors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidLoginException.class)
    public StandardError invalidLogin(InvalidLoginException e){
        return new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

}
