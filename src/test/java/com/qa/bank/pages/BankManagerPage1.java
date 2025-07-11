package com.qa.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage1 {

    public BankManagerPage1(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath ="//input[@placeholder='Post Code']")
    WebElement zipCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerSubmit;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;
    @FindBy(css = "#userSelect")
    WebElement customer;
    @FindBy(css = "#currency")
    WebElement currency;
    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement customerButton;

    @FindBy(tagName = "input")
    WebElement searchBar;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> customerInformation;

    public void addCustomerFunctionality1(WebDriver driver,String firstName,String lastName,String zipCode,
                                        String expectedMessage) throws InterruptedException {
        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
        addCustomerSubmit.submit();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();

    }

    public void openAccountFunctionality1(WebDriver driver,String customer,String currency,String expectedMessage) throws InterruptedException {
        openAccountButton.click();
        BrowserUtils.selectBy(this.customer,customer,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void getCustomerInformationFunctionality1(String customerName,String lastName,String zipCode){
        customerButton.click();
        searchBar.sendKeys(customerName);

        List<String> expectedInformation= Arrays.asList(customerName,lastName,zipCode);

        for(int i=0; i<customerInformation.size() ; i++){

            Assert.assertEquals(customerInformation.get(i).getText(),expectedInformation.get(i));
        }

    }









}
