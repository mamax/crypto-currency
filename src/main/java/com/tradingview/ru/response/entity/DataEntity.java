package com.tradingview.ru.response.entity;

import com.tradingview.ru.request.entity.AEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DataEntity extends AEntity{

    private String s;
    private List<String> d;

}
