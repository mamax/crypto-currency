package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Query extends AEntity {

    @Override
    public String toString() {
        return "query{" +
                "types=" + types +
                '}';
    }

    private List<String> types;
}
