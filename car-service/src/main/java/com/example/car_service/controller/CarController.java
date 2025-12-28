package com.example.car_service.controller;

import com.example.car_service.dto.CarResponse;
import com.example.car_service.entity.Car;
import com.example.car_service.services.CarServices;
import com.example.car_service.services.CarServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarServices services;

    @GetMapping
    public ResponseEntity<List<Car>> showAllCars(){
        return ResponseEntity.ok(services.showAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id){
        return ResponseEntity.ok(services.showById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        services.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping()
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(services.addCar(car));
    }
    @GetMapping("/name/{carName}")
    public ResponseEntity<CarResponse> showCarByName(@PathVariable String carName){
    return ResponseEntity.ok(services.getCarByCarName(carName));
    }
}
