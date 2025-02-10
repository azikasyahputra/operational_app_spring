package com.demo.operational.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CrudInterface<T> {
    Page<T> getAllActiveData(List<String> selectableFields, Pageable pageable);
    Page<T> search(Map<String, Object> filters, Pageable pageable,List<String> selectableFields, List<String> whereFields);
    List<T> getAllData();
    T saveData(T entity);
    T updateData(Integer id, T entity);
    T getById(Integer id);
    void deleteData(Integer id);
    T softDeleteData(Integer id);
}
