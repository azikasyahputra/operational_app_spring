package com.demo.operational.controller;

import com.demo.operational.model.Biaya;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/biaya")
public class BiayaController extends CrudController<Biaya> {
    @Override
    protected String getEntityPath() {
        return "biaya";  // Specify the unique path for the User entity
    }

    @Override
    protected String getViewPath() {
        return "master-input/biaya";
    }

    @Override
    protected String getEntityName() {
        return "biaya";
    }

    @Override
    protected Biaya getNewEntity() {
        return new Biaya();
    }

    @Override
    protected String getEntityNameLower() {
        return "biaya";
    }

    @Override
    protected List<String> getSelectableFields() {
        return Arrays.asList("id", "namaBiaya", "kategoriBiaya");
    }

    @Override
    protected List<String> getWhereFields() {
        return Arrays.asList("namaBiaya", "kategoriBiaya");
    }
}
