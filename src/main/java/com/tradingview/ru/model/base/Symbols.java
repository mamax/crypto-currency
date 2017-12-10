package com.tradingview.ru.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Symbols extends AEntity{

    @Override
    public String toString() {
        return "symbols{" +
                "query=" + query +
                '}';

    }

    public Symbols(Query query) {
        this.query = query;
    }

    private Query query;
}
