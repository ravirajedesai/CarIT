package com.example.carBuy_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class CarBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String carName;

    @Column(nullable = false)
    private Double carPrice;

    @Column(nullable = false)
    private Double total;
}
