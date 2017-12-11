package com.tradingview.ru.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tradingview.ru.request.entity.AEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DataEntity extends AEntity {

    @JsonProperty("s")
    private String serialCode;
    @JsonProperty("d")
    private List<String> data;

}
