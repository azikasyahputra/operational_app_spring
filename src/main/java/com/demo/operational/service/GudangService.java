package com.demo.operational.service;

import com.demo.operational.model.Gudang;
import com.demo.operational.repository.GudangRepository;
import org.springframework.stereotype.Service;

@Service
public class GudangService extends CrudService<Gudang> {

    private final GudangRepository gudangRepository;

    public GudangService(GudangRepository gudangRepository) {
        this.gudangRepository = gudangRepository;
    }
}
