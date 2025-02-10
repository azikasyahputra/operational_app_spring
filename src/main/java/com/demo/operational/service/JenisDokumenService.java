package com.demo.operational.service;

import com.demo.operational.model.JenisDokumen;
import com.demo.operational.repository.JenisDokumenRepository;
import org.springframework.stereotype.Service;

@Service
public class JenisDokumenService extends CrudService<JenisDokumen> {

    private final JenisDokumenRepository jenisDokumenRepository;

    public JenisDokumenService(JenisDokumenRepository jenisDokumenRepository) {
        this.jenisDokumenRepository = jenisDokumenRepository;
    }
}
