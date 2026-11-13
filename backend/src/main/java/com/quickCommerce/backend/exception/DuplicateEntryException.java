package com.quickCommerce.backend.exception;

public class DuplicateEntryException extends RuntimeException{
    public DuplicateEntryException(){
        super();
    }
    public DuplicateEntryException(String msg){
        super(msg);
    }
}
