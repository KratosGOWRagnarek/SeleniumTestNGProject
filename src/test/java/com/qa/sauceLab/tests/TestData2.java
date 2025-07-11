package com.qa.sauceLab.tests;

import org.testng.annotations.DataProvider;

public class TestData2 {

    @DataProvider (name = "negative")
    public Object[][] getNegativeMessage(){
        return new Object [][]{
                {"standard_user","secret","Epic sadface: Username and password do not match any user in this service"},
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},


        };

    }
}
