package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Symbols extends AEntity{

    public Symbols(Query query) {
        this.query = query;
    }

    private Query query;
}
