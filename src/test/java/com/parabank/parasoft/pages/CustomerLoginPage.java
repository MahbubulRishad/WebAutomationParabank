package com.parabank.parasoft.pages;

import com.parabank.parasoft.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage {
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public CustomerLoginPage fillUsername(String username){
        getWebElement(By.cssSelector("[name = 'username']")).sendKeys(username);
        return this;
    }

    public CustomerLoginPage fillPassword(String password){
        getWebElement(By.cssSelector("[name = 'password']")).sendKeys(password);
        return this;
    }

    public OverviewPage clickLoginBtn(){
        getWebElement(By.cssSelector("[value = 'Log In']")).click();
        return getInstance(OverviewPage.class);
    }
}
