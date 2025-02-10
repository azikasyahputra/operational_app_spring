package com.demo.operational.service;

import com.demo.operational.model.Kosongan;
import com.demo.operational.repository.KosonganRepository;
import org.springframework.stereotype.Service;

@Service
public class KosonganService extends CrudService<Kosongan> {

    private final KosonganRepository kosonganRepository;

    public KosonganService(KosonganRepository kosonganRepository) {
        this.kosonganRepository = kosonganRepository;
    }
}
