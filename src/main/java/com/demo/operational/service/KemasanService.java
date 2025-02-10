package com.demo.operational.service;

import com.demo.operational.model.Kemasan;
import com.demo.operational.repository.KemasanRepository;
import org.springframework.stereotype.Service;

@Service
public class KemasanService extends CrudService<Kemasan> {

    private final KemasanRepository kemasanRepository;

    public KemasanService(KemasanRepository kemasanRepository) {
        this.kemasanRepository = kemasanRepository;
    }
}
