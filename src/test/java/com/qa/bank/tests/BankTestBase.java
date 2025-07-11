package com.qa.bank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BankTestBase {
/*
1-TestBase is a class that we store our Setup Automation and Tear Down(closing pages)

 */
    public WebDriver driver;
    @BeforeMethod// it runs before each @Test annotation
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("bank_url"));
    }

    @AfterMethod// it runs after each @Test annotation
    public void tearDown(){
        driver.quit();
        //during the development(writing automation) just comment out
    }


}
