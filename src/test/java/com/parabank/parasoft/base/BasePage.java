package com.parabank.parasoft.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page{
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement webElement = null;

        try{
            waitForWaitElement(selector);
            webElement = driver.findElement(selector);
        }catch (Exception e){
            System.out.println(selector.toString() + "Not Found");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
       List<WebElement> webElements = null;

        try{
            waitForWaitElement(selector);
            webElements = driver.findElements(selector);
        }catch (Exception e){
            System.out.println(selector.toString() + "Web Elements Not Found");
        }
        return webElements;
    }

    @Override
    public void waitForWaitElement(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        }catch (Exception e){
            System.out.println(selector.toString() + "Not Found");
        }
    }
}
