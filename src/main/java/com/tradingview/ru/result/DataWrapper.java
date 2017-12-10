package com.tradingview.ru.result;

import com.tradingview.ru.model.base.AEntity;
import com.tradingview.ru.result.entity.DataEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DataWrapper extends AEntity {

    private List<DataEntity> data;
    private int totalCount;

}
