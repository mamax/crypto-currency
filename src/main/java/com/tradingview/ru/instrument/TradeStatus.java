package com.tradingview.ru.instrument;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TradeStatus {

    private String description;
    private double close;
    private double change;
    private double changeAbs;
    private double high;
    private double low;
    private double volume;
    private double recommendAll;
    private String exchange;

}
