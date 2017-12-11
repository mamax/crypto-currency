package com.tradingview.ru.instrument;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TradeStatus {

    private String name;
    private String description;
    private double close;
    private Long change;
    private Long changeAbs;
    private Long high;
    private Long low;
    private Long volume;
    private Long recommendAll;
    private String exchange;


}
