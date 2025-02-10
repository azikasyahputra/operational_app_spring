package com.demo.operational.service;

import com.demo.operational.model.Order;
import com.demo.operational.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class OrderService extends CrudService<Order> {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long getOrdersToday() {
        LocalDate today = LocalDate.now();
        return orderRepository.countOrdersToday(today);
    }

    public Long getOrdersThisMonth() {
        YearMonth currentMonth = YearMonth.now();
        return orderRepository.countOrdersThisMonth(currentMonth.getMonthValue(), currentMonth.getYear());
    }
}
