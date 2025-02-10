package com.demo.operational.service;

import com.demo.operational.interfaces.CrudInterface;
import com.demo.operational.repository.BaseRepository;
import com.demo.operational.utils.EntityHelper;
import com.demo.operational.utils.FilterConditionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public abstract class CrudService<T> implements CrudInterface<T> {

    @Autowired
    private BaseRepository<T,Integer> repository;

    @Override
    public Page<T> getAllActiveData(List<String> selectableFields, Pageable pageable) {
        // Override this in specific services if you need specific filtering logic.
        return repository.findAllByDeleted("Tidak", pageable, selectableFields);
    }

    @Override
    public Page<T> search(Pageable pageable, List<FilterConditionHelper> filters, List<String> selectableFields, List<String> groupByFields, String sortField, boolean ascending) {
        return repository.search(pageable, filters, selectableFields, groupByFields, sortField,ascending);
    }

    @Override
    public List<T> getAllData() {
        return repository.findAll();
    }

    @Override
    public T saveData(T entity) {
        return repository.save(entity);
    }

    @Override
    public T updateData(Integer id, T updatedEntity) {
        Optional<T> existingEntity = repository.findById(id);
        if (!existingEntity.isPresent()) {
            return null;
        }
        T entity = existingEntity.get();
        EntityHelper.copyNonNullProperties(entity, updatedEntity);
        return repository.save(entity);
    }

    @Override
    public T getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteData(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public T softDeleteData(Integer id) {
        Optional<T> existingEntity = repository.findById(id);
        if (!existingEntity.isPresent()) {
            return null;
        }
        T entity = existingEntity.get();

        entity = EntityHelper.markAsDeleted(entity);

        if (entity == null) {
            return null;
        }

        return repository.save(entity);
    }
}