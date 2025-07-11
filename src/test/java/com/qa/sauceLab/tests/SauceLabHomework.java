package com.qa.sauceLab.tests;

import com.qa.sauceLab.pages.SauceLabLoginPage;
import org.testng.annotations.Test;

public class SauceLabHomework extends SauceLabTestBase{
    @Test(dataProvider = "homew", dataProviderClass = TestData3.class)
    public void homework(String header, String text, String price){
        SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage(driver);
        sauceLabLoginPage.loginFunctionality("standard_user","secret_sauce");
        sauceLabLoginPage.titlesAndContains(driver,header,text,price);

    }

}
