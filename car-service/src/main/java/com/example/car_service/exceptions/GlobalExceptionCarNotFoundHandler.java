package com.example.car_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionCarNotFoundHandler {
    @ExceptionHandler(CarNotFound.class)
    public ResponseEntity<Map<String,Object>> carNotFoundExceptionHandler(CarNotFound ex){
        Map<String,Object>response=new HashMap<>();
        response.put("Message",ex.getMessage());
        response.put("Status",404);
        response.put("TimeStamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
