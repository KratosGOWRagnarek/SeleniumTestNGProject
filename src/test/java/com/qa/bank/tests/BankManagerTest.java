package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import com.qa.bank.pages.BankLoginPage1;
import com.qa.bank.pages.BankManagerPage;
import com.qa.bank.pages.BankManagerPage1;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BankManagerTest extends BankTestBase{

@Test
    public void validateAddCustomerFunctionality() throws InterruptedException {
    BankLoginPage bankLoginPage = new BankLoginPage(driver);
    bankLoginPage.clickManagerButton();

    BankManagerPage bankManagerPage = new BankManagerPage(driver);
    bankManagerPage.addCustomerFunctionality(driver,"Sam","Av","60000","Customer added successfully");
}

    @Test
    public void validateOpenAccountFunctionality() throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, ConfigReader.readProperty("bank_name"),ConfigReader.readProperty("bank_lastname"),ConfigReader.readProperty("bank_zipcode"),ConfigReader.readProperty("bank_message1"));
        bankManagerPage.openAccountFunctionality(driver,ConfigReader.readProperty("bank_fullName"),ConfigReader.readProperty("bank_currency"),ConfigReader.readProperty("bank_message2"));

    }

    @Parameters({"name","lastName","zip","message1","fullN","currency","message2"})
    @Test
    public void ParametersValidateOpenAccountFunctionality(String name, String lastName, String zip, String message1, String fullN, String currency, String message2) throws InterruptedException {
        BankLoginPage1 bankLoginPage1 = new BankLoginPage1(driver);
        bankLoginPage1.clickManagerLogin();
        BankManagerPage1 bankManagerPage1 = new BankManagerPage1(driver);

        bankManagerPage1.addCustomerFunctionality1(driver,name, lastName,zip,message1);
        bankManagerPage1.openAccountFunctionality1(driver,fullN,currency,message2);
        bankManagerPage1.getCustomerInformationFunctionality1(name,lastName,zip);

    }




}
