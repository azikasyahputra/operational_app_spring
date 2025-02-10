package com.demo.operational.service;

import com.demo.operational.model.PengeluaranDetail;
import com.demo.operational.repository.PengeluaranDetailRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class PengeluaranDetailService extends CrudService<PengeluaranDetail> {

    private final PengeluaranDetailRepository pengeluaranDetailRepository;

    public PengeluaranDetailService(PengeluaranDetailRepository pengeluaranDetailRepository) {
        this.pengeluaranDetailRepository = pengeluaranDetailRepository;
    }

    public double calculatePengeluaranToday() {
        LocalDate today = LocalDate.now();
        return pengeluaranDetailRepository.sumPengeluaranToday(today);
    }

    public double calculatePengeluaranThisMonth() {
        YearMonth currentMonth = YearMonth.now();
        return pengeluaranDetailRepository.sumPengeluaranThisMonth(currentMonth.getMonthValue(), currentMonth.getYear());
    }
}
