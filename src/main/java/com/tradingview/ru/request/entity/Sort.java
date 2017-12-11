package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sort extends AEntity{

    private String sortBy;
    private String sortOrder;

}
