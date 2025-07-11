package com.qa.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    //We store our WebElements and Methods from LoginPage in this class
    //constructor is a way to initialize your instance variables(belongs to class)
    //every page we will create constructor
    public BankLoginPage(WebDriver driver){
        //It means it will initialize the WebElements in this class (key example from car)
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;


    @FindBy(tagName = "strong")
    WebElement header;


    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;


    @FindBy(xpath = "//button[contains(@ng-click,'manager')]")
    WebElement managerLoginButton;


    public void checkLoginPageInformation(String expectedBankName) {
        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());

        Assert.assertEquals(header.getText(), expectedBankName);

        Assert.assertTrue(customerLoginButton.isDisplayed() && customerLoginButton.isEnabled());

        Assert.assertTrue(managerLoginButton.isDisplayed() && managerLoginButton.isEnabled());
        //CTRL + D or COMMAND + D --> It duplicates the line
        //Do not provide any data in the method(hard code), for ex.(XYZ Bank)
        //ctrl+Shift+up or down moves line of the code
    }

    public void clickManagerButton(){
        managerLoginButton.click();
    }




}
