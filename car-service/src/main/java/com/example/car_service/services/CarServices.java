package com.example.car_service.services;

import com.example.car_service.dto.CarResponse;
import com.example.car_service.entity.Car;

import java.util.List;

public interface CarServices {
    List<Car> showAll();
    Car showById(Long id);
    void deleteCarById(Long id);
    Car addCar(Car car);
    CarResponse getCarByCarName(String carName);
}
