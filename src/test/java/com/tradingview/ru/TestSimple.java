package com.tradingview.ru;

import com.fasterxml.jackson.databind.JsonNode;
import com.tradingview.ru.base.TestSuite;
import com.tradingview.ru.instrument.TradeStatus;
import com.tradingview.ru.request.EntityWrapper;
import com.tradingview.ru.response.DataWrapper;
import com.tradingview.ru.response.entity.DataEntity;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNot.not;

public class TestSimple extends TestSuite {

    Map<String, Map<String, TradeStatus>> itemsMap = new HashMap();

    private JsonNode postJson;
    private EntityWrapper atWr;
    private String response;
    private DataWrapper resultWrp;

    @BeforeClass
    public void setUp(){
        postJson = parseJsonNode("me");
    }

    @Test
    public void testSimple() throws IOException {
        atWr = getWrapper(postJson, EntityWrapper.class);

        response = given()
                .contentType(ContentType.JSON)
                .body(atWr)
        .when()
                .post("/scan")
        .then()
                .statusCode(200)
                .body("", not(empty()))
                .extract()
                .body()
                .asString();
    }

    @Test(dependsOnMethods = "testSimple")
    public void testParse() throws IOException {
        resultWrp = transformResponse(response, DataWrapper.class);

        List<DataEntity> dataEntityList = resultWrp.getData();

        for (DataEntity entity : dataEntityList){
            TradeStatus tradeStatus = new TradeStatus();
            HashMap<String, TradeStatus> map = new HashMap<>();

            String key =  entity.getSerialCode();

            String secondKey = entity.getData().get(0);
            tradeStatus.setDescription(entity.getData().get(1));
            tradeStatus.setClose(Double.parseDouble(entity.getData().get(2)));
            tradeStatus.setChange(Double.parseDouble(entity.getData().get(3)));
            tradeStatus.setChangeAbs(Double.parseDouble(entity.getData().get(4)));
            tradeStatus.setHigh(Double.parseDouble(entity.getData().get(5)));
            tradeStatus.setLow(Double.parseDouble(entity.getData().get(6)));
            tradeStatus.setVolume(Double.parseDouble(entity.getData().get(7)));
            tradeStatus.setRecommendAll(Double.parseDouble(entity.getData().get(8)));
            tradeStatus.setExchange(entity.getData().get(9));

            map.put(secondKey, tradeStatus);

            itemsMap.put(key, map);
        }

        System.out.println(itemsMap.entrySet());

    }

}
