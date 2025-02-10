package com.demo.operational.controller;

import com.demo.operational.enums.QueryOperator;
import com.demo.operational.service.CrudService;
import com.demo.operational.utils.FilterConditionHelper;
import com.demo.operational.utils.PageHelper;
import com.demo.operational.validation.CreateGroup;
import com.demo.operational.validation.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public abstract class CrudController<T> {

    @Autowired
    private CrudService<T> crudService;

    // Index (Listing with Pagination)
    @RequestMapping("/list")
    public String index(Model model,
                        @RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "5") int size,
                        @RequestParam Map<String, String> searchParams,
                        @RequestParam(required = false) String sortField,
                        @RequestParam(defaultValue = "asc") String sortDirection) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<T> entityPage;

        List<FilterConditionHelper> filters = new ArrayList<>();

        Map<String, QueryOperator> allowedFields = getWhereFields();

        searchParams.forEach((key, value) -> {
            if (value != null && !value.isEmpty() && allowedFields.containsKey(key)) {
                QueryOperator operator = allowedFields.get(key);
                filters.add(new FilterConditionHelper(key, value, operator));
            }
        });

        String finalSortField = (sortField != null && !sortField.isEmpty()) ? sortField : getSortField();
        boolean ascending = (sortDirection != null) ? sortDirection.equalsIgnoreCase("asc") : isSortAscending();

        if (!filters.isEmpty()) {
            entityPage = crudService.search(pageable, filters, getSelectableFields(), getGroupByFields(), finalSortField, ascending);
        } else {
            entityPage = crudService.getAllActiveData(getSelectableFields(), pageable);
        }

        if (page > entityPage.getTotalPages() && entityPage.getTotalPages() > 1) {
            return "redirect:/" + getEntityPath() + "/list?page=" + (entityPage.getTotalPages()) + "&size=" + size;
        }

        model.addAttribute(getEntityPath() + "sPage", entityPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", entityPage.getTotalPages());
        model.addAttribute("pageSize", size);

        return PageHelper.loadPage(model, getViewPath() + "/index", getEntityName());
    }

    // Create - Show the form for creating a new entity
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute(getEntityNameLower(), getNewEntity());
        return PageHelper.loadPage(model, getViewPath() + "/create", "Create " + getEntityName());
    }

    // Create - Process the form to save a new entity
    @PostMapping("/create")
    public String saveData(@Validated(CreateGroup.class) @ModelAttribute T entity,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return PageHelper.loadPage(model, getViewPath() + "/create", "Create " + getEntityName());
        }

        crudService.saveData(entity);
        return "redirect:/" + getEntityPath() + "/list";
    }

    // Read - View details of a single entity
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        Optional<T> entity = Optional.ofNullable(crudService.getById(id));
        if (entity.isPresent()) {
            model.addAttribute(getEntityNameLower(), entity.get());
            return PageHelper.loadPage(model, getViewPath() + "/view", "View " + getEntityName());
        }
        return "redirect:/" + getEntityPath() + "/list";
    }

    // Update - Show the form to edit an existing entity
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<T> entity = Optional.ofNullable(crudService.getById(id));
        if (entity.isPresent()) {
            model.addAttribute(getEntityNameLower(), entity.get());
            return PageHelper.loadPage(model, getViewPath() + "/edit", "Edit " + getEntityName());
        }
        return "redirect:/" + getEntityPath() + "/list";
    }

    // Update - Process the form to update an existing entity
    @PostMapping("/edit/{id}")
    public String updateData(@PathVariable Integer id, @Validated(UpdateGroup.class) @ModelAttribute T entity,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return PageHelper.loadPage(model, getViewPath() + "/edit", "Edit " + getEntityName());
        }
        crudService.updateData(id,entity);
        return "redirect:/" + getEntityPath() + "/list";
    }

    // Delete - Delete the entity
    @GetMapping("/delete/{id}")
    public String deleteData(@PathVariable Integer id) {
        crudService.softDeleteData(id);
        return "redirect:/" + getEntityPath() + "/list";
    }


    private String extractFieldFromKey(String key) {
        return key.split("__")[0]; // Extracts the field name from `age__gt`
    }

    private QueryOperator extractOperatorFromKey(String key) {
        if (key.endsWith("__gt")) return QueryOperator.GREATER_THAN;
        if (key.endsWith("__lt")) return QueryOperator.LESS_THAN;
        if (key.endsWith("__gte")) return QueryOperator.GREATER_THAN_OR_EQUAL;
        if (key.endsWith("__lte")) return QueryOperator.LESS_THAN_OR_EQUAL;
        if (key.endsWith("__like")) return QueryOperator.LIKE;
        if (key.endsWith("__neq")) return QueryOperator.NOT_EQUAL;
        return QueryOperator.EQUAL; // Default
    }

    // Abstract methods to define entity-specific paths and names
    protected abstract String getEntityPath();
    protected abstract String getViewPath();
    protected abstract String getEntityName();
    protected abstract T getNewEntity();
    protected abstract String getEntityNameLower();
    protected abstract List<String> getSelectableFields();
    protected abstract Map<String, QueryOperator> getWhereFields();
    protected abstract List<String> getGroupByFields();
    protected abstract String getSortField();
    protected abstract boolean isSortAscending();
}