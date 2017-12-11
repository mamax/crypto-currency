package com.tradingview.ru.request;

import com.tradingview.ru.request.entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EntityWrapper extends AEntity {

    private List<Filter> filter;
    private Symbols symbols;
    private List<String> columns;
    private Sort sort;
    private Options options;
    private List<Integer> range;

}
