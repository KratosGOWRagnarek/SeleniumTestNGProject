package com.qa.sauceLab.tests;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider (name="positiveLogin")
    public Object[][] getPositiveLoginData(){
        return new Object[][]{
                {"standard_user", "secret_sauce","Swag Labs","https://www.saucedemo.com/inventory.html"},
                {"problem_user", "secret_sauce","Swag Labs","https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce","Swag Labs","https://www.saucedemo.com/inventory.html"},
                {"error_user", "secret_sauce","Swag Labs","https://www.saucedemo.com/inventory.html"},
                {"visual_user", "secret_sauce","Swag Labs","https://www.saucedemo.com/inventory.html"},

        };

    }
}
