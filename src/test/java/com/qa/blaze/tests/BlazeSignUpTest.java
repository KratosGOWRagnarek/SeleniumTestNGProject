package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeMainPage;
import com.qa.blaze.pages.BlazeSignUpPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeSignUpTest extends BlazeTestBase{
    @Parameters({"username","password", "message"})
    @Test
    public void validateSignUpFunctionality(String username, String password, String message) throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        blazeMainPage.clickSignUpButton();

        BlazeSignUpPage blazeSignUpPage = new BlazeSignUpPage(driver);
        blazeSignUpPage.signUpFunctionality(driver,username,
                password,message);

    }
}
