package com.demo.operational.service;

import com.demo.operational.model.Invoice;
import com.demo.operational.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class InvoiceService extends CrudService<Invoice> {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Long getInvoicesToday() {
        LocalDate today = LocalDate.now();
        return invoiceRepository.countInvoicesToday(today);
    }

    public Long getInvoicesThisMonth() {
        YearMonth currentMonth = YearMonth.now();
        return invoiceRepository.countInvoicesThisMonth(currentMonth.getMonthValue(), currentMonth.getYear());
    }

    public double calculateLabaToday() {
        LocalDate today = LocalDate.now();
        return invoiceRepository.sumInvoicesToday(today);
    }

    public double calculateLabaMonth() {
        YearMonth currentMonth = YearMonth.now();
        return invoiceRepository.sumInvoicesThisMonth(currentMonth.getMonthValue(), currentMonth.getYear());
    }
}
