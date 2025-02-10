package com.demo.operational.utils;

import com.demo.operational.enums.QueryOperator;

public class FilterConditionHelper {
    private String field;
    private Object value;
    private QueryOperator operator;

    public FilterConditionHelper(String field, Object value, QueryOperator operator) {
        this.field = field;
        this.value = value;
        this.operator = operator;
    }

    public String getField() {
        return field;
    }

    public Object getValue() {
        return value;
    }

    public QueryOperator getOperator() {
        return operator;
    }
}
