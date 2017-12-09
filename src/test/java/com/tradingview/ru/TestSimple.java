package com.tradingview.ru;

import com.tradingview.ru.base.BaseTest;
import com.tradingview.ru.instrument.Instrument;
import com.tradingview.ru.instrument.Item;
import com.tradingview.ru.page.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSimple extends BaseTest {

    Map<Instrument, Item> itemMap = new HashMap();

    @Test
    public void testSimple(){
        goToUrlWrapper("https://ru.tradingview.com/cryptocurrency-signals/");
        HomePage homePage = new HomePage(driver);

        for (int i=1; i<homePage.getElements().size(); i++){
            String instrField = driver.findElement(By.xpath(String.format("//*[@id='js-screener-container']/div[4]/table/tbody/tr[%s]/td[1]/a", i))).getText();
            String typeField = driver.findElement(By.xpath(String.format("//*[@id='js-screener-container']/div[4]/table/tbody/tr[*]/td[1]/span", i))).getText();
            String priceField = driver.findElement(By.xpath(String.format("//*[@id='js-screener-container']/div[4]/table/tbody/tr[%s]/td[2]/span", i))).getText();
            String ratingField = driver.findElement(By.xpath(String.format("//*[@id='js-screener-container']/div[4]/table/tbody/tr[%s]/td[8]/span", i))).getText();
            String stockField = driver.findElement(By.xpath(String.format("//*[@id='js-screener-container']/div[4]/table/tbody/tr[%s]/td[9]", i))).getText();

            Instrument instrument = new Instrument(instrField, typeField);
            Item item = new Item( Double.parseDouble(priceField), ratingField, stockField);
            itemMap.put(instrument, item);
        }

        System.out.println(itemMap.entrySet());
    }
}
