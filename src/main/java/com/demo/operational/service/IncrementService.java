package com.demo.operational.service;

import com.demo.operational.model.Increment;
import com.demo.operational.repository.IncrementRepository;
import org.springframework.stereotype.Service;

@Service
public class IncrementService extends CrudService<Increment> {

    private final IncrementRepository incrementRepository;

    public IncrementService(IncrementRepository incrementRepository) {
        this.incrementRepository = incrementRepository;
    }
}
