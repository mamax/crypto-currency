package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Query extends AEntity {

    public Query(List<String> types) {
        this.types = types;
    }

    private List<String> types;
}
