package com.parabank.parasoft.testCases.testCases;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.OpenAccountPage;
import com.parabank.parasoft.testCases.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseTest {

    @Test
    public void OpenCheckingAccountShouldSuccess(){
        OpenAccountPage openAccountPage = page.getInstance(CustomerLoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickOpenNewAccountLink()
                .selectAccountTypeByIndex(0)
                .clickOpenNewAccountBtn();

        Assert.assertTrue(openAccountPage.hasNewAccountId());
    }

    @Test
    public void OpenSavingAccountShouldSuccess(){
        OpenAccountPage openAccountPage = page.getInstance(CustomerLoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickOpenNewAccountLink()
                .selectAccountTypeByVisibleText("SAVINGS")
                .clickOpenNewAccountBtn();

        Assert.assertTrue(openAccountPage.hasNewAccountId());
    }
}
