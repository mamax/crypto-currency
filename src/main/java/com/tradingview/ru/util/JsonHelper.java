package com.tradingview.ru.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Represents JsonHelper to configure ObjectMapper.
 */
public class JsonHelper {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static <T> T getWrapper(JsonNode jsonNode, Class<T> item)
            throws IOException {
        return JsonHelper.getObjectMapper().convertValue(jsonNode, item);
    }

    public static <T> T transformResponse(String resp, Class<T> item)
            throws IOException {
        JsonNode node = getJsonNode(resp);
        return JsonHelper.getObjectMapper()
                .convertValue(node, item);
    }

    public static JsonNode getJsonNode(String resp)
            throws IOException {
        return JsonHelper.getObjectMapper().readTree(resp);
    }

    protected static JsonNode parseJsonNode(String jsonFileName) {
        File file = new File(ClassLoader.getSystemResource("json/" + jsonFileName + ".json").getFile());
        try {
            return JsonHelper.getObjectMapper().readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
