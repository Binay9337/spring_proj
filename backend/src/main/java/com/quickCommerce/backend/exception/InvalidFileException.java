package com.quickCommerce.backend.exception;

public class InvalidFileException extends RuntimeException{

    public InvalidFileException(String msg){
        super(msg);
    }
}
