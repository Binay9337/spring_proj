package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionDto {
    private String path;
    private HttpStatus statusCode;
    private String errorMessage;
    private LocalDateTime errorTime;

}
