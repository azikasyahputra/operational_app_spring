package com.demo.operational.service;

import com.demo.operational.model.Lapangan;
import com.demo.operational.repository.LapanganRepository;
import org.springframework.stereotype.Service;

@Service
public class LapanganService extends CrudService<Lapangan> {

    private final LapanganRepository lapanganRepository;

    public LapanganService(LapanganRepository lapanganRepository) {
        this.lapanganRepository = lapanganRepository;
    }
}
