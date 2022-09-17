package com.example.ecommerce.exception;


import com.example.ecommerce.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> alreadyExistException(AlreadyExistException ex){
        ErrorResponse response=new ErrorResponse(ex.getMessage(),"Fail to Create");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> apiResponse = new HashMap<>();
        ex.getAllErrors().stream().forEach(error ->
                apiResponse.put(((FieldError) error).getField(), error.getDefaultMessage())
        );

        return new  ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
