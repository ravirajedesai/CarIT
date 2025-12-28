package com.example.carBuy_service.repository;

import com.example.carBuy_service.entity.CarBuy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBuyRepo extends JpaRepository<CarBuy,Long> {
}
