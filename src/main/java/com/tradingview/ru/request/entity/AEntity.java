package com.tradingview.ru.request.entity;

import com.tradingview.ru.util.JsonHelper;

public abstract class AEntity {

    public String toJson() {
        return JsonHelper.toJson(this);
    }

}
