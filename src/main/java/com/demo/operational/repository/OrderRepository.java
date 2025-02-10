package com.demo.operational.repository;

import com.demo.operational.model.Order;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order,Integer> {
    @Query("SELECT COUNT(o) FROM Order o WHERE o.deleted = 'Tidak' AND o.tanggalOrder = :date")
    Long countOrdersToday(LocalDate date);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.deleted = 'Tidak' AND MONTH(o.tanggalOrder) = :month AND YEAR(o.tanggalOrder) = :year")
    Long countOrdersThisMonth(int month, int year);
}
