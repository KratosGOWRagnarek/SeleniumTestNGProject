package com.qa.blaze.tests;

import org.testng.annotations.DataProvider;

public class BlazeTestData {
    @DataProvider(name = "products")
    public Object[][] getProductData(){
        return new Object[][]{
                {"Laptops","MacBook air","$700 *includes tax","shared L3","Product added"},
                {"Phones", "Samsung galaxy s7","$800 *includes tax","phone packs","Product added"}
        };

    }


}
