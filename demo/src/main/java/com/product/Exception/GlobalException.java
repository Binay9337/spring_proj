package com.product.Exception;

import com.product.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(CategoryAlreadyExists.class)
    public ResponseEntity<ExceptionDto> categoryAlreadyExistException(CategoryAlreadyExists ex, WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(webRequest.getDescription(false), HttpStatus.CONFLICT,ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);
    }

    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity<ExceptionDto> categoryNotFoundException(CategoryNotFound ex, WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(webRequest.getDescription(false), HttpStatus.CONFLICT,ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGlobalException(Exception ex,WebRequest webRequest){
        ExceptionDto exceptionDto = new ExceptionDto(webRequest.getDescription(false), HttpStatus.CONFLICT,ex.getMessage(), LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionDto);
    }
}
