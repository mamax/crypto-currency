package com.tradingview.ru.model.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sort extends AEntity{

    public Sort(String sortBy, String sortOrder) {
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
    }

    private String sortBy;
    private String sortOrder;

    @Override
    public String toString() {
        return "sort{" +
                "sortBy='" + sortBy + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }

}
