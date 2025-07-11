package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserUtils;

import java.time.Duration;

public class BankCustomerPage {
    public BankCustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    @FindBy(xpath = "//button[contains(text(),'Customer')]")
    WebElement customerLoginButton;

    @FindBy(css = "#userSelect")
    WebElement selectName;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;

    @FindBy(css = "#userSelect")
    WebElement myName;

    @FindBy(xpath = "//div//span")
    WebElement greetingMessage;

    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;

    @FindBy(xpath = "//input")
    WebElement inputAmount;

    @FindBy(xpath = "//button[.='Deposit']")
    WebElement confirmDepositButton;

    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement depositSuccessfulMessage;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawButton;

    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement confirmWithdrawButton;

    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement transactionSuccessMessage;

    int expectedAmount= 200;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionButton;

    @FindBy(xpath = "//td[.='500']")
    WebElement actualDepositedAmount;


    @FindBy(xpath = "//td[.='300']")
    WebElement actualWithdrawnAmount;




    public void testTransaction(WebDriver driver,String customer,String greetingM,String expectedMessage,
                                String expectedMessage2 ) throws InterruptedException {
        homeButton.click();
        customerLoginButton.click();
        BrowserUtils.selectBy(myName,customer,"text");
        Thread.sleep(1000);
        loginButton.click();
        Assert.assertEquals(greetingMessage.getText(), greetingM);
        depositButton.click();
        inputAmount.sendKeys("500");
        Thread.sleep(1000);
        confirmDepositButton.click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(depositSuccessfulMessage));
        Assert.assertEquals(depositSuccessfulMessage.getText(),expectedMessage);
        withdrawButton.click();
        Assert.assertEquals(depositSuccessfulMessage.getCssValue("color"),"rgba(255, 0, 0, 1)");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.elementToBeClickable(inputAmount));
        Thread.sleep(1000);
        inputAmount.sendKeys("300");
        Thread.sleep(1000);
        confirmWithdrawButton.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOf(transactionSuccessMessage));
        Assert.assertEquals(transactionSuccessMessage.getText(),expectedMessage2);
        Assert.assertEquals(transactionSuccessMessage.getCssValue("color"),"rgba(255, 0, 0, 1)");
        Thread.sleep(1000);
        transactionButton.click();

        int actualDeposit = Integer.parseInt(actualDepositedAmount.getText());
        int actualWithdraw = Integer.parseInt(actualWithdrawnAmount.getText());
        int actualResult = actualDeposit-actualWithdraw;
        Assert.assertEquals(expectedAmount,actualResult);



    }

}
