package com.demo.operational.service;

import com.demo.operational.model.InvoiceDetail;
import com.demo.operational.repository.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailService extends CrudService<InvoiceDetail> {

    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }
}
