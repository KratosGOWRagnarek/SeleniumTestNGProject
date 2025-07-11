package com.qa.sauceLab.tests;

import org.testng.annotations.DataProvider;

public class TestData3 {
    @DataProvider(name = "homew")
    public Object [][] test3(){
        return new Object[][]{
                {"Sauce Labs Backpack","Sly Pack","29.99"},
                {"Sauce Labs Bike Light","Water-resistant","9.99"},
                {"Sauce Labs Bolt T-Shirt","bolt T-shirt","15.99"},
                {"Sauce Labs Fleece Jacket","quarter-zip fleece jacket","49.99"},
                {"Sauce Labs Onesie","Reinforced 3-snap","7.99"},
                {"Test.allTheThings() T-Shirt (Red)","classic Sauce Labs t-shirt","15.99"},

        };
    }


}