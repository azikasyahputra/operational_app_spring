package com.demo.operational.interfaces;

import com.demo.operational.utils.FilterConditionHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CrudInterface<T> {
    Page<T> getAllActiveData(List<String> selectableFields, Pageable pageable);
    Page<T> search(Pageable pageable, List<FilterConditionHelper> filters, List<String> selectableFields, List<String> groupByFields, String sortField, boolean ascending);
    List<T> getAllData();
    T saveData(T entity);
    T updateData(Integer id, T entity);
    T getById(Integer id);
    void deleteData(Integer id);
    T softDeleteData(Integer id);
}
