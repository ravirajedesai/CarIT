package com.example.carBuy_service.fein;

import com.example.carBuy_service.dto.CarResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "car-service")
public interface CarClient {
    @GetMapping("/cars/name/{carName}")
    CarResponse showCarByName(@PathVariable String carName);

}
