package com.tradingview.ru.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.NoSuchFileException;

public class BaseTest extends BrowserConf {

    protected static WebDriver driver;
    protected static Logger log;
//
//    @BeforeTest
//    public static void setupClass() {
//        ChromeDriverManager.getInstance().setup();
//    }


    @BeforeSuite
    public static void setUpLogger(ITestContext itr){
        String testName = itr.getCurrentXmlTest().getName();
        log = LoggerFactory.getLogger(testName);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public static void setUp(@Optional("CHROME") String browser){
        driver = BrowserConf.getDriver(browser, log);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        if (driver != null) {
            driver.quit();
            log.info("Close browser");
        }
    }

    public static void captureScreenShot(String fileName) throws IOException {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(
                    OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" + File.separator + fileName + ".jpg"));
        } catch (IOException e) {
            log.error(String.valueOf(e));
        }
    }

    protected void goToUrlWrapper(String text){
        driver.get(text);
        log.info("On the home page " + text);
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
