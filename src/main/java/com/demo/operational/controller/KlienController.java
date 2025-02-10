package com.demo.operational.controller;

import com.demo.operational.enums.QueryOperator;
import com.demo.operational.model.Klien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return Arrays.asList("id", "namaClient", "alamatClient","kotaClient","kodeposClient");
    }

    @Override
    protected Map<String, QueryOperator> getWhereFields() {
        Map<String, QueryOperator> fields = new HashMap<>();
        fields.put("namaClient", QueryOperator.LIKE);
        fields.put("alamatClient", QueryOperator.LIKE);
        fields.put("kotaClient", QueryOperator.LIKE);
        fields.put("kodeposClient", QueryOperator.LIKE);
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
