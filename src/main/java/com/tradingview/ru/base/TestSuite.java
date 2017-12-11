package com.tradingview.ru.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.tradingview.ru.util.JsonHelper;

import java.io.File;
import java.io.IOException;

public class TestSuite extends BaseTest {

    protected <T> T getWrapper(JsonNode jsonNode, Class<T> item)
            throws IOException {
        return JsonHelper.getObjectMapper().convertValue(jsonNode, item);
    }

    protected <T> T transformResponse(String resp, Class<T> item)
            throws IOException {
        JsonNode node = getJsonNode(resp);
        return JsonHelper.getObjectMapper()
                .convertValue(node, item);
    }

    private JsonNode getJsonNode(String resp)
            throws IOException {
        return JsonHelper.getObjectMapper().readTree(resp);
    }

    protected JsonNode parseJsonNode(String jsonFileName) {
        File file = new File(ClassLoader.getSystemResource("json/" + jsonFileName + ".json").getFile());
        try {
            return JsonHelper.getObjectMapper().readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
