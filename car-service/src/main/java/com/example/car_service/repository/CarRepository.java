package com.example.car_service.repository;

import com.example.car_service.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {
    Optional<Car> findByCarName(String carName);
}
