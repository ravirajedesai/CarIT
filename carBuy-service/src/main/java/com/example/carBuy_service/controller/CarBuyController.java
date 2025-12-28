package com.example.carBuy_service.controller;

import com.example.carBuy_service.dto.CarResponse;
import com.example.carBuy_service.entity.CarBuy;
import com.example.carBuy_service.services.CarBuyServices;
import com.example.carBuy_service.services.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class CarBuyController {

    private final CarBuyServices service;

    @GetMapping
    public ResponseEntity<Page<CarBuy>>
    showAllOrders(@RequestParam int pageNo,
                  @RequestParam int pageSize,
                  @RequestParam String sortBy,
                  @RequestParam String sortDir){
        return ResponseEntity.ok(service.showAllOrders(pageNo,pageSize,sortBy,sortDir));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarBuy> getOrderById(@PathVariable Long id){
        CarBuy byId=service.showCarByOrderId(id);
        return ResponseEntity.ok(byId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<CarBuy> addCarOrder(@RequestParam String carName,
                                              @RequestParam String ownerName){
        CarBuy addOrder=service.placeOrder(carName,ownerName);
        return ResponseEntity.status(HttpStatus.CREATED).body(addOrder);
    }
}
