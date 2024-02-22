package com.parabank.parasoft.testCases.base;

import com.parabank.parasoft.base.BasePage;
import com.parabank.parasoft.base.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

   protected WebDriver driver;
    private Properties properties;

     public Page page;

    public BaseTest() {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Config.Properties";
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeMethod
    public void browserSetUp() {
        String browserName = properties.getProperty("browserName");
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("headless")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browserName.equalsIgnoreCase("chromeHeadless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--chromeHeadless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            System.out.println("Please provide Browser");
        }

        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();
        page = new BasePage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public String getUsername(){
       return properties.getProperty("username");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }
}
