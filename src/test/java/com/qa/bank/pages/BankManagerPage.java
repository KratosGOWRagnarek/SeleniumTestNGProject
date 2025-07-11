package com.qa.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankManagerPage {
    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement zipCode;

    @FindBy(xpath = "//button[.='Add Customer']")
    WebElement submitButton;

//    @FindBy(xpath = "//button[@ng-class='btnClass2']")
//    WebElement openAccount;


    public void addCustomerFunctionality(WebDriver driver, String firstname, String lastName, String zipcode, String expectedMessage) throws InterruptedException {
        addCustomerButton.click();
       this.firstName.sendKeys(firstname);
       this.lastName.sendKeys(lastName);
       this.zipCode.sendKeys(zipcode);
       Thread.sleep(3000);
       submitButton.click();

       Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();

    }

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccount;

    @FindBy(css ="#userSelect" )
    WebElement customerSelect;

    @FindBy(css = "#currency")
    WebElement currencySelect;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;



    public void openAccountClick(){
        openAccount.click();
    }

    public void openAccountFunctionality(WebDriver driver,String customer, String currencySelect,String expectedMessage) throws InterruptedException {
        openAccountClick();
        Thread.sleep(2000);
        BrowserUtils.selectBy(customerSelect,customer,"text");
        BrowserUtils.selectBy(this.currencySelect,currencySelect,"value");
        Thread.sleep(2000);
        processButton.click();

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();

    }










}
