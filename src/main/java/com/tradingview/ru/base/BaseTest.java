package com.tradingview.ru.base;

import com.fasterxml.jackson.databind.JsonNode;
import com.tradingview.ru.util.JsonHelper;
import com.tradingview.ru.util.ScreenShot;
import io.restassured.RestAssured;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.util.Properties;

public class BaseTest extends BrowserConf {

    public static Properties config = new Properties();
    protected static String url;
    protected static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(ScreenShot.class);

    @BeforeSuite
    public static String initBaseUrl()  throws IOException  {

        config.load(getResource("config.properties"));
        url = config.getProperty("baseUrl");
        return url;
    }

    @BeforeSuite(dependsOnMethods = "initBaseUrl")
    public void init() {
        RestAssured.baseURI = url;
    }

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

    public static void captureScreenShot(String fileName) throws IOException {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(
                    OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" + File.separator + fileName + ".jpg"));
        } catch (IOException e) {
            LOGGER.error(String.valueOf(e));
        }
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


    public static InputStream getResource(String properties) throws NoSuchFileException
    {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream is = loader.getResourceAsStream(properties);

        if(is == null)
        {
            throw new NoSuchFileException("Resource file not found. Note that the current directory is the source folder!");
        }

        return is;
    }


}
