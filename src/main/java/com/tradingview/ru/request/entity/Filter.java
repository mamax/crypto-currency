package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Filter extends AEntity {

    private String left;
    private String operation;
    private List<Long> right;

    public Filter(String left, String operation, List<Long> right) {
        this.left = left;
        this.operation = operation;
        this.right = right;
    }

    public Filter(String left, String operation) {
        this.left = left;
        this.operation = operation;
    }



}
