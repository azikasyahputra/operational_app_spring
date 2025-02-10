package com.demo.operational.controller;

import com.demo.operational.model.Klien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/klien")
public class KlienController extends CrudController<Klien> {

    @Override
    protected String getEntityPath() {
        return "klien";  // Specify the unique path for the User entity
    }

    @Override
    protected String getViewPath() {
        return "master-input/klien";
    }

    @Override
    protected String getEntityName() {
        return "Klien";
    }

    @Override
    protected Klien getNewEntity() {
        return new Klien();
    }

    @Override
    protected String getEntityNameLower() {
        return "klien";
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
