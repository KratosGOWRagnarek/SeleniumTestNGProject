package com.qa.bank.tests;

import com.qa.bank.pages.*;
import org.testng.annotations.Test;

public class BankTransactionTest extends BankTestBase{
    @Test
    public void validateBankTransaction() throws InterruptedException {
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Sam", "Av", "60000", "Customer added successfully");
        bankManagerPage.openAccountFunctionality(driver, "Sam Av", "Dollar", "Account created successfully");

        BankCustomerPage bankCustomerPage = new BankCustomerPage(driver);
        bankCustomerPage.testTransaction(driver,"Sam Av","Sam Av","Deposit Successful","Transaction successful");
    }

    @Test
    public void validateTransactionFunctionality() throws InterruptedException {

        BankLoginPage1 bankLoginPage1=new BankLoginPage1(driver);
        bankLoginPage1.clickManagerLogin();
        BankManagerPage1 bankManagerPage1=new BankManagerPage1(driver);
        bankManagerPage1.addCustomerFunctionality1(driver,"Ahmet","Baldir","52454", "Customer added successfully");
        bankManagerPage1.openAccountFunctionality1(driver,"Ahmet Baldir","Dollar","Account created successfully with account Number :");
        bankManagerPage1.getCustomerInformationFunctionality1("Ahmet","Baldir","52454");
        bankLoginPage1.clickHomeButton();
        bankLoginPage1.clickCustomerLogin();
        BankCustomerPage1 bankCustomerPage1=new BankCustomerPage1(driver);
        bankCustomerPage1.transactionFunctionality("Ahmet Baldir","Welcome Ahmet Baldir !!","500","Deposit Successful",
                "300","Transaction successful","rgba(255, 0, 0, 1)");


    }


}
