package com.example.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String entity,fieldName,fieldValue;

    public ResourceNotFoundException(String entity, String fieldName, String fieldValue) {
        super(String.format("%s either deleted or not exist with %s : %s",entity,fieldName,fieldValue));
        this.entity = entity;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
