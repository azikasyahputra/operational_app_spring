package com.demo.operational.service;

import com.demo.operational.model.Pilihan;
import com.demo.operational.repository.PilihanRepository;
import org.springframework.stereotype.Service;

@Service
public class PilihanService extends CrudService<Pilihan> {

    private final PilihanRepository pilihanRepository;

    public PilihanService(PilihanRepository pilihanRepository) {
        this.pilihanRepository = pilihanRepository;
    }
}
