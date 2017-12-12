package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Options extends AEntity {

    public Options(String lang) {
        this.lang = lang;
    }

    private String lang;
}
