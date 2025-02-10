package com.demo.operational.repository;

import com.demo.operational.utils.FilterConditionHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface FilterRepository<T> {
    Page<T> search(
            Pageable pageable,
            List<FilterConditionHelper> filters,
            List<String> selectableFields,
            List<String> groupByFields,
            String sortField,
            boolean ascending
    );
}
