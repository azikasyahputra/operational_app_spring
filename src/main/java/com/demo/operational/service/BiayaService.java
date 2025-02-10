package com.demo.operational.service;

import com.demo.operational.model.Biaya;
import com.demo.operational.repository.BiayaRepository;
import org.springframework.stereotype.Service;

@Service
public class BiayaService extends CrudService<Biaya> {

    private final BiayaRepository biayaRepository;

    public BiayaService(BiayaRepository biayaRepository) {
        this.biayaRepository = biayaRepository;
    }
}
