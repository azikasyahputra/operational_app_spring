package com.demo.operational.service;

import com.demo.operational.model.Supir;
import com.demo.operational.repository.SupirRepository;
import org.springframework.stereotype.Service;

@Service
public class SupirService extends CrudService<Supir> {

    private final SupirRepository supirRepository;

    public SupirService(SupirRepository supirRepository) {
        this.supirRepository = supirRepository;
    }
}
