package com.demo.operational.repository;

import com.demo.operational.enums.QueryOperator;
import com.demo.operational.utils.FilterConditionHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FilterRepositoryImpl<T> implements FilterRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<T> search(Pageable pageable,List<FilterConditionHelper> filters, List<String> selectableFields, List<String> groupByFields, String sortField, boolean ascending) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery((Class<T>) Object.class);
        Root<T> root = query.from((Class<T>) Object.class);

        List<Predicate> predicates = new ArrayList<>();

        // Apply filters dynamically
        for (FilterConditionHelper filter : filters) {
            String field = filter.getField();
            Object value = filter.getValue();
            QueryOperator operator = filter.getOperator();

            Path<?> path = root.get(field);

            switch (operator) {
                case EQUAL:
                    predicates.add(cb.equal(path, value));
                    break;
                case NOT_EQUAL:
                    predicates.add(cb.notEqual(path, value));
                    break;
                case LIKE:
                    predicates.add(cb.like(cb.lower(path.as(String.class)), "%" + value.toString().toLowerCase() + "%"));
                    break;
                case GREATER_THAN:
                    predicates.add(cb.greaterThan(path.as(Number.class).as(Double.class), ((Number) value).doubleValue()));
                    break;
                case LESS_THAN:
                    predicates.add(cb.lessThan(path.as(Number.class).as(Double.class), ((Number) value).doubleValue()));
                    break;
                case GREATER_THAN_OR_EQUAL:
                    predicates.add(cb.greaterThanOrEqualTo(path.as(Number.class).as(Double.class), ((Number) value).doubleValue()));
                    break;
                case LESS_THAN_OR_EQUAL:
                    predicates.add(cb.lessThanOrEqualTo(path.as(Number.class).as(Double.class), ((Number) value).doubleValue()));
                    break;
            }
        }

        query.select(root).where(predicates.toArray(new Predicate[0]));

        // Apply grouping if needed
        if (!groupByFields.isEmpty()) {
            List<Expression<?>> groupByExpressions = new ArrayList<>();
            for (String field : groupByFields) {
                groupByExpressions.add(root.get(field));
            }
            query.groupBy(groupByExpressions);
        }

        // Apply sorting
        if (sortField != null && !sortField.isEmpty()) {
            Order order = ascending ? cb.asc(root.get(sortField)) : cb.desc(root.get(sortField));
            query.orderBy(order);
        }

        TypedQuery<T> typedQuery = entityManager.createQuery(query);

        // Apply pagination
        int totalRows = typedQuery.getResultList().size();
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<T> resultList = typedQuery.getResultList();
        return new PageImpl<>(resultList, pageable, totalRows);
    }
}
