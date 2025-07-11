package com.qa.bank.tests;

import com.qa.bank.pages.BankLoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BankLoginTest extends BankTestBase { //parent-child

    //In test class, I generally use Validate keyword in test class
    @Parameters("bank")
    @Test
    public void validateLoginPageInformation(String bank){
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.checkLoginPageInformation(bank);

    }
}
