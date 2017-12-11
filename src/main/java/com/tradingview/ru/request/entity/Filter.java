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

}
