package com.demo.operational.service;

import com.demo.operational.model.Pelayaran;
import com.demo.operational.repository.PelayaranRepository;
import org.springframework.stereotype.Service;

@Service
public class PelayaranService extends CrudService<Pelayaran> {

    private final PelayaranRepository pelayaranRepository;

    public PelayaranService(PelayaranRepository pelayaranRepository) {
        this.pelayaranRepository = pelayaranRepository;
    }
}
