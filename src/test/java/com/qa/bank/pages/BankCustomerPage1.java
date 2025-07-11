package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankCustomerPage1 {


    public BankCustomerPage1(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#userSelect")
    WebElement customerNameBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement amount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement message;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawalButton;

    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    WebElement balance;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[@class='ng-binding'][2]")
    WebElement credit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[@class='ng-binding'][2]")
    WebElement debit;


    public void transactionFunctionality(String customerName,String expectedMessage,String depositAmount,String expectedDepositMessage,
                                         String withDrawAmount,String expectedWithDrawMessage,String expectedColor) throws InterruptedException {

        //Login as Customer
        BrowserUtils.selectBy(customerNameBox,customerName,"text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(header.getText(),expectedMessage);

        //Do deposit Transaction
        depositButton.click();
        amount.sendKeys(depositAmount);
        submitButton.click();
        Assert.assertEquals(message.getText(),expectedDepositMessage);
        Assert.assertEquals(message.getCssValue("color"),expectedColor);
        Thread.sleep(3000);
        //Do WithDrawl Transaction
        withdrawalButton.click();
        Thread.sleep(1000);
        amount.sendKeys(withDrawAmount);
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(message.getText(),expectedWithDrawMessage);
        Assert.assertEquals(message.getCssValue("color"),expectedColor);
        Thread.sleep(3000);
        //Save the balance
        int balanceAmount=Integer.parseInt(balance.getText());

        //Do Validation of Transaction
        transactionButton.click();
        int finalAmount=Integer.parseInt(credit.getText()) - Integer.parseInt(debit.getText());
        Assert.assertEquals(finalAmount,balanceAmount);

    }















}
