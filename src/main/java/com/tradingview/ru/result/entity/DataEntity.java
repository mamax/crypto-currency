package com.tradingview.ru.result.entity;

import com.tradingview.ru.model.base.AEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DataEntity extends AEntity{

    private String s;
    private List<String> d;

}
