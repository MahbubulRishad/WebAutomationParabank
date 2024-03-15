package com.parabank.parasoft.pages;

import com.parabank.parasoft.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends BasePage {
    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenAccountPage selectAccountTypeByIndex(int index) {
        new Select(getWebElement(By.cssSelector("#type"))).selectByIndex(index);
        return this;
    }

    public OpenAccountPage selectAccountTypeByVisibleText(String text) {
        new Select(getWebElement(By.cssSelector("#type"))).selectByVisibleText(text);
        return this;
    }

    public OpenAccountPage clickOpenNewAccountBtn() {
        getWebElement(By.xpath("//input[normalize-space(@value)=\"Open New Account\"]")).click();
        return this;
    }

    public boolean hasNewAccountId() {
        return getWebElements(By.id("newAccountId")).size() > 0;
    }

}
