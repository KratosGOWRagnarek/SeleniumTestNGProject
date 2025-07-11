package com.qa.sauceLab.tests;

import com.qa.sauceLab.pages.SauceLabLoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLabNegativeLoginTest extends SauceLabTestBase{

    @Test(dataProvider = "negative",dataProviderClass = TestData2.class)
    public void validateErrorMessages(String name, String password,String message){
        SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage(driver);
        sauceLabLoginPage.loginFunctionality(name, password);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),message);


    }
}
