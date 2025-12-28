package com.example.carBuy_service.services;

import com.example.carBuy_service.dto.CarResponse;
import com.example.carBuy_service.entity.CarBuy;

import java.util.List;

public interface CarBuyServices {

    List<CarBuy> showAllOrders();
    CarBuy showCarByOrderId(Long id);
    void deleteCarById(Long id);
    CarBuy placeOrder(String name,String ownerName);

}
