package com.demo.operational.controller;

import com.demo.operational.enums.QueryOperator;
import com.demo.operational.model.Biaya;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    protected Map<String, QueryOperator> getWhereFields() {
        Map<String, QueryOperator> fields = new HashMap<>();
        fields.put("namaBiaya", QueryOperator.LIKE);
        fields.put("kategoriBiaya", QueryOperator.LIKE);
        return fields;
    }

    @Override
    protected List<String> getGroupByFields() {
        return List.of();
    }

    @Override
    protected String getSortField(){
        return "id";
    };

    @Override
    protected boolean isSortAscending(){
        return false;
    };
}
