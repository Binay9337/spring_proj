package com.quickCommerce.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> handleRunTimeException(RuntimeException e) {
        Map<String, String> map = new HashMap<>();
        map.put("Title", "some error occurred");
        map.put("Detail", e.getMessage());
        map.put("TimeStamp", LocalDateTime.now().toString());
        return map;
    }
    @ExceptionHandler(DuplicateEntryException.class)
    public ProblemDetail handleDuplicateEntryException(RuntimeException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT,e.getMessage());
    problemDetail.setProperty("TimeStamp",LocalDateTime.now());
        return problemDetail;
    }
    @ExceptionHandler(ResourceNotFound.class)
    public ProblemDetail handleResourceNotFound(RuntimeException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,e.getMessage());
    problemDetail.setProperty("TimeStamp",LocalDateTime.now());
        return problemDetail;
    }
    @ExceptionHandler(InvalidFileException.class)
    public ProblemDetail handleInvalidFileException(RuntimeException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
    problemDetail.setProperty("TimeStamp",LocalDateTime.now());
        return problemDetail;
    }
 @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ProblemDetail handleMethodNotValidException(HttpRequestMethodNotSupportedException e) {
    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.METHOD_NOT_ALLOWED,e.getMessage());
    problemDetail.setProperty("TimeStamp",LocalDateTime.now());
        return problemDetail;
    }



}
