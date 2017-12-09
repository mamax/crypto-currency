package com.tradingview.ru.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashSet;
import java.util.List;

public class HomePage extends BasePage {

    public List<WebElement> getElements() {
        return elements;
    }

    @FindBy(xpath = "//tr[@class='tv-data-table__row tv-data-table__stroke tv-screener-table__result-row']")
    private List<WebElement> elements;

    @FindBy(xpath = "//*[@id='js-screener-container']/div[4]/table/tbody/tr[*]/td[1]/a")
    private List<WebElement> instrument;

    @FindBy(xpath = "//*[@id='js-screener-container']/div[4]/table/tbody/tr[*]/td[2]/span")
    private List<WebElement> price;

    @FindBy(xpath = "//*[@id='js-screener-container']/div[4]/table/tbody/tr[*]/td[8]/span")
    private List<WebElement> rating;

    @FindBy(xpath = "//*[@id='js-screener-container']/div[4]/table/tbody/tr[*]/td[9]/span")
    private List<WebElement> stock;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void scanRows(HashSet list) {
        for (WebElement element : elements){
            list.add(element);
        }
    }
}
