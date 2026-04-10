package com.mentorhints.springbootdemo.advice;

import com.mentorhints.springbootdemo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleInvalidException(StudentNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("status", "404");
        errorMap.put("Error: ", ex.getMessage());
        return errorMap;
    }
}

