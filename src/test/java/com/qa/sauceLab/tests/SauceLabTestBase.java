package com.qa.sauceLab.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.Driver;

public class SauceLabTestBase {
    public WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver("chrome");
        driver.get(ConfigReader.readProperty("sauceLab_url"));

    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();

    }
}
