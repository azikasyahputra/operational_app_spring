package com.demo.operational.service;

import com.demo.operational.model.Referensi;
import com.demo.operational.repository.ReferensiRepository;
import org.springframework.stereotype.Service;

@Service
public class ReferensiService extends CrudService<Referensi> {

    private final ReferensiRepository referensiRepository;

    public ReferensiService(ReferensiRepository referensiRepository) {
        this.referensiRepository = referensiRepository;
    }
}
