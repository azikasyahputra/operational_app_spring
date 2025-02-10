package com.demo.operational.service;

import java.time.YearMonth;

import com.demo.operational.model.BukuKasDetail;
import com.demo.operational.repository.BukuKasDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class BukuKasDetailService extends CrudService<BukuKasDetail> {

    private final BukuKasDetailRepository bukuKasDetailRepository;

    public BukuKasDetailService(BukuKasDetailRepository bukuKasDetailRepository) {
        this.bukuKasDetailRepository = bukuKasDetailRepository;
    }

    public double calculateTotalIncome() {
        YearMonth currentMonth = YearMonth.now();
        return bukuKasDetailRepository.sumTotalBrutoThisMonth(currentMonth.getMonthValue(), currentMonth.getYear());
    }

    public double calculateTotalExpense() {
        YearMonth currentMonth = YearMonth.now();
        double total_biaya = bukuKasDetailRepository.sumTotalBiayaThisMonth(currentMonth.getMonthValue(), currentMonth.getYear());
        double total_kewajiban = bukuKasDetailRepository.sumTotalKewajibanThisMonth(currentMonth.getMonthValue(), currentMonth.getYear());
        return total_biaya + total_kewajiban;
    }
}
