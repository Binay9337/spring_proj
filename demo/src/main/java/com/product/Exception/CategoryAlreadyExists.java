package com.product.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CategoryAlreadyExists extends RuntimeException{
    public CategoryAlreadyExists(String msg){
        super(msg);
    }
}
