package com.parabank.parasoft.pages;

import com.parabank.parasoft.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasLogoutLink(){
        return getWebElements(By.cssSelector("[href*='logout']")).size() > 0;
    }

    public OpenAccountPage clickOpenNewAccountLink(){
        getWebElement(By.cssSelector("a[href*=\"openaccount.htm\"]")).click();
        return getInstance(OpenAccountPage.class);
    }
}
