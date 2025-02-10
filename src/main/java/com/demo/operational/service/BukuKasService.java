package com.demo.operational.service;

import com.demo.operational.model.BukuKas;
import com.demo.operational.repository.BukuKasRepository;
import org.springframework.stereotype.Service;

@Service
public class BukuKasService extends CrudService<BukuKas> {

    private final BukuKasRepository bukuKasRepository;

    public BukuKasService(BukuKasRepository bukuKasRepository) {
        this.bukuKasRepository = bukuKasRepository;
    }
}
