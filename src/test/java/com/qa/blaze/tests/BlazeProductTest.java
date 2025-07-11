package com.qa.blaze.tests;

import com.qa.blaze.pages.BlazeMainPage;
import com.qa.blaze.pages.BlazeProductPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BlazeProductTest extends BlazeTestBase{
    @Test(dataProvider = "products",dataProviderClass = BlazeTestData.class)
    public void validateProductInformation(String category, String product, String price, String description,
                                           String message) throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        blazeMainPage.chooseCategory(category);

        BlazeProductPage blazeProductPage= new BlazeProductPage(driver);
        blazeProductPage.chooseProduct(product);
        blazeProductPage.productInformation(driver,product,
                price,description,message);
    }

}
