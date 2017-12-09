package com.tradingview.ru.instrument;

import lombok.Data;

@Data
public class Instrument {

    public Instrument(String name, String type) {
        this.name = name;
        this.type = type;
    }

    private String name;
    private String type;

}
