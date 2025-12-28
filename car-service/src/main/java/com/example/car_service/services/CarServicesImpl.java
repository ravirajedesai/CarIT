package com.example.car_service.services;

import com.example.car_service.dto.CarResponse;
import com.example.car_service.entity.Car;
import com.example.car_service.exceptions.CarNotFound;
import com.example.car_service.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServicesImpl implements CarServices{

    private final CarRepository repository;

    @Override
    public List<Car> showAll() {
        return repository.findAll();
    }
    @Override
    public Car showById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new CarNotFound("Car Not Found: "+id));
    }
    @Override
    public void deleteCarById(Long id) {
        if(!repository.existsById(id)){
            throw new CarNotFound("Car Not Found to Delete: "+id);
        }
        repository.deleteById(id);
    }
    @Override
    public Car addCar(Car car) {
        return repository.save(car);
    }

    @Override
    public CarResponse getCarByCarName(String carName) {
        Car car=repository.findByCarName(carName)
                .orElseThrow(()->
                        new CarNotFound("Car Not Found With Name: "+carName));

        return new CarResponse(
                car.getCarName(),
                car.getCarPrice()
        );
    }
}
