package com.demo.operational.service;

import com.demo.operational.model.Status;
import com.demo.operational.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService extends CrudService<Status>  {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
}
