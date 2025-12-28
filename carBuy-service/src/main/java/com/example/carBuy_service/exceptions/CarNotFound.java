package com.example.carBuy_service.exceptions;

public class CarNotFound extends RuntimeException{
    public CarNotFound(String message) {
        super(message);
    }
}
