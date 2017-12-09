package com.tradingview.ru.instrument;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {

    private Double price;
    private String rating;
    private String stockChange;

    public Item( double price, String rating, String stockChange) {
        this.price = price;
        this.rating = rating;
        this.stockChange = stockChange;
    }
}
