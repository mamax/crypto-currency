package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Options extends AEntity {

    @Override
    public String toString() {
        return "options{" +
                "\"lang\":\"" + lang + '\"' +
                '}';
    }

    private String lang;
}
