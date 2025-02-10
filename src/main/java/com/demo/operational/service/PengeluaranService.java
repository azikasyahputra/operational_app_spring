package com.demo.operational.service;

import com.demo.operational.model.Pengeluaran;
import com.demo.operational.repository.PengeluaranRepository;
import org.springframework.stereotype.Service;

@Service
public class PengeluaranService extends CrudService<Pengeluaran> {

    private final PengeluaranRepository pengeluaranRepository;

    public PengeluaranService(PengeluaranRepository pengeluaranRepository) {
        this.pengeluaranRepository = pengeluaranRepository;
    }
}
