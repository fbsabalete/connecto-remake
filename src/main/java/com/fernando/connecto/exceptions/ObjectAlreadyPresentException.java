package com.fernando.connecto.exceptions;

public class ObjectAlreadyPresentException extends RuntimeException{
    public ObjectAlreadyPresentException(String message) {
        super(message);
    }
}
