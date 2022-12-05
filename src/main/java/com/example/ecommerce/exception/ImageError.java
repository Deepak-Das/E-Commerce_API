package com.example.ecommerce.exception;

public class ImageError extends RuntimeException{

    String message;

    public ImageError(String message) {
        super(message);
    }
}
