package com.tradingview.ru.response;

import com.tradingview.ru.request.entity.AEntity;
import com.tradingview.ru.response.entity.DataEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DataWrapper extends AEntity {

    private List<DataEntity> data;
    private int totalCount;

}
