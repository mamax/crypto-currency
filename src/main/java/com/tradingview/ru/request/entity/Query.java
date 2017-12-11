package com.tradingview.ru.request.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Query extends AEntity {

    private List<String> types;
}
