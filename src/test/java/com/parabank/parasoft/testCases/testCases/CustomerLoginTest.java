package com.parabank.parasoft.testCases.testCases;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.testCases.base.BaseTest;
import com.parabank.parasoft.utill.WelcomeTittle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BaseTest {
    @Test
    public void LoginShouldSuccess() {
        CustomerLoginPage customerLoginPage = page.getInstance(CustomerLoginPage.class);
        customerLoginPage = customerLoginPage
                .fillUsername(getUsername())
                .fillPassword(getPassword());

        OverviewPage overviewPage = customerLoginPage
                .clickLoginBtn();

        Assert.assertTrue(overviewPage.hasLogoutLink());
    }

    @Test
    public void LoginShouldSuccess2() {
        OverviewPage overviewPage = page.getInstance(CustomerLoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();

        Assert.assertTrue(overviewPage.hasLogoutLink());
    }
}
