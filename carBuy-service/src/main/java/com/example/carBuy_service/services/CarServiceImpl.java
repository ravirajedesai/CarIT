package com.example.carBuy_service.services;

import com.example.carBuy_service.dto.CarResponse;
import com.example.carBuy_service.entity.CarBuy;
import com.example.carBuy_service.exceptions.CarNotFound;
import com.example.carBuy_service.exceptions.OrderNotFound;
import com.example.carBuy_service.fein.CarClient;
import com.example.carBuy_service.repository.CarBuyRepo;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarBuyServices{

    private final CarBuyRepo repo;
    private final CarClient carClient;

    @Override
    public Page<CarBuy> showAllOrders(int pageNo,
                                      int pageSize,
                                      String sortBy,
                                      String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase("ASC")
                ?Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(pageNo-1,pageSize,sort);
        return repo.findAll(pageable);
    }
    @Override
    public CarBuy showCarByOrderId(Long id) {
        return repo.findById(id)
                .orElseThrow(()->new OrderNotFound("Order Not Found: "+id));
    }
    @Override
    public void deleteCarById(Long id) {
        if(!repo.existsById(id)){
            throw new OrderNotFound("Car Not Found For Delete: "+id);
        }
        repo.deleteById(id);
    }
    @Override
    public CarBuy placeOrder(String carName,String ownerName) {

        CarResponse response;
        try {
            response=carClient.showCarByName(carName);
        } catch (FeignException.NotFound ex) {
            throw new CarNotFound("Car Not Found: "+carName);
        }

        CarBuy order=new CarBuy();
        order.setCarName(response.getCarName());
        order.setOwnerName(ownerName);
        order.setCarPrice(response.getCarPrice());

        Double insurance= 200000.0;
        order.setTotal(response.getCarPrice()+insurance);

        return repo.save(order);
    }
}
