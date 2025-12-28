package com.example.carBuy_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponse {
    private String carName;
    private Double carPrice;
}
