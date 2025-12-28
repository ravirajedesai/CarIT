package com.example.carBuy_service.services;

import com.example.carBuy_service.entity.CarBuy;
import org.springframework.data.domain.Page;


public interface CarBuyServices {

    Page<CarBuy> showAllOrders(int pageNo,
                               int pageSize,
                               String sortBy,
                               String sortDir);
    CarBuy showCarByOrderId(Long id);
    void deleteCarById(Long id);
    CarBuy placeOrder(String name,String ownerName);

}
