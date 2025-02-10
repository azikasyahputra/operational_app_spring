package com.demo.operational.service;

import com.demo.operational.interfaces.CrudInterface;
import com.demo.operational.repository.BaseRepository;
import com.demo.operational.utils.EntityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class CrudService<T> implements CrudInterface<T> {

    @Autowired
    private BaseRepository<T,Integer> repository;

    @Override
    public Page<T> getAllActiveData(List<String> selectableFields, Pageable pageable) {
        // Override this in specific services if you need specific filtering logic.
        return repository.findAllByDeleted("Tidak", pageable, selectableFields);
    }

    @Override
    public Page<T> search(Map<String, Object> filters, Pageable pageable, List<String> selectableFields, List<String> whereFields) {
        // Ensure filters only apply to allowed `whereFields`
        Map<String, Object> validFilters = new HashMap<>();
        filters.forEach((key, value) -> {
            if (whereFields.contains(key)) {  // Now using whereFields passed as argument
                validFilters.put(key, value);
            }
        });

        return repository.search(validFilters, pageable, selectableFields, whereFields);
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