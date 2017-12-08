package com.tradingview.ru;

import com.tradingview.ru.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSimple extends BaseTest {

    @Test
    public void testSimple(){
        open("https://ru.tradingview.com/cryptocurrency-signals/");
        WebElement customer = $(By.cssSelector(".tv-site-widget__title"));
        System.out.println(customer.getText());
    }
}
