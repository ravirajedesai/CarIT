package com.example.car_service.exceptions;

public class CarNotFound extends RuntimeException{
    public CarNotFound(String message) {
        super(message);
    }
}
