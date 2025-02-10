package com.demo.operational.service;

import com.demo.operational.model.Klien;
import com.demo.operational.repository.KlienRepository;
import org.springframework.stereotype.Service;

@Service
public class KlienService extends CrudService<Klien> {

    private final KlienRepository klienRepository;

    public KlienService(KlienRepository klienRepository) {
        this.klienRepository = klienRepository;
    }
}
