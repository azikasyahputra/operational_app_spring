package com.demo.operational.service;

import com.demo.operational.model.OrderTrucking;
import com.demo.operational.repository.OrderTruckingRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderTruckingService extends CrudService<OrderTrucking> {

    private final OrderTruckingRepository orderTruckingRepository;

    public OrderTruckingService(OrderTruckingRepository orderTruckingRepository) {
        this.orderTruckingRepository = orderTruckingRepository;
    }
}
