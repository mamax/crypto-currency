package com.tradingview.ru.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;
import java.util.Properties;

public class BaseTest{

    private static Properties config = new Properties();
    private static String url;

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


    private static InputStream getResource(String properties) throws NoSuchFileException
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
