package com.qa.sauceLab.tests;

import com.qa.sauceLab.pages.SauceLabLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SaucelabLoginTest extends SauceLabTestBase{



    @Test(dataProvider = "positiveLogin", dataProviderClass = TestData.class)
    public void validateLoginWithDataProvider(String username, String password, String title, String url){
        SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage(driver);
        sauceLabLoginPage.loginFunctionality(username,password);
        Assert.assertEquals(driver.getTitle(),title);
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
}
