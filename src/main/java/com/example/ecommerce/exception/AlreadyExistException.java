package com.example.ecommerce.exception;

public class AlreadyExistException extends RuntimeException{
    private String entity,fieldName,fieldValue;

    public AlreadyExistException(String entity, String fieldName, String fieldValue) {
        super(String.format("%s already exist with %s : %s",entity,fieldName,fieldValue));
        this.entity = entity;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
