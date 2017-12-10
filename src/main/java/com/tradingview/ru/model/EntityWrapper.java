package com.tradingview.ru.model;

import com.tradingview.ru.model.base.*;
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

    public EntityWrapper(List<Filter> filter, Symbols symbols, List<String> columns, Sort sort, Options options, List<Integer> range) {
        this.filter = filter;
        this.symbols = symbols;
        this.columns = columns;
        this.sort = sort;
        this.options = options;
        this.range = range;
    }

    @Override
    public String toString() {
        return "{" +
                "\"filter\":" + filter +'"'+
                ", \"symbols\":" + symbols + '"'+
                ", \"columns\":" + columns  +'"'+
                ", \"sort\":" + sort  +'"'+
                ", \"options\":" + options  +'"'+
                ", \"range\":" + range +'"'+
                '}';
    }
}
