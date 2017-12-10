package com.tradingview.ru;

import com.fasterxml.jackson.databind.JsonNode;
import com.tradingview.ru.base.BaseTest;
import com.tradingview.ru.instrument.Instrument;
import com.tradingview.ru.instrument.Item;
import com.tradingview.ru.model.EntityWrapper;
import com.tradingview.ru.result.DataWrapper;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNot.not;

public class TestSimple extends BaseTest {

    Map<Instrument, Item> itemMap = new HashMap();
    private JsonNode postJson;
    private EntityWrapper atWr;
    private String response;
    private DataWrapper resultWrp;

    @BeforeClass
    public void setUp(){
        postJson = parseJsonNode("me");
    }

    @BeforeMethod
    public void setUpData() throws IOException {
        atWr = getWrapper(postJson, EntityWrapper.class);

    }

    @Test
    public void testSimple(){
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
        System.out.println(resultWrp);
    }

}
