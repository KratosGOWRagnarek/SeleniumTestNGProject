package com.qa.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BlazeSignUpPage {
    public BlazeSignUpPage (WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "#sign-username")
    WebElement usernameInput;

    @FindBy(css = "#sign-password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Sign')]")
    WebElement signUpButton;

    public void signUpFunctionality(WebDriver driver,String username, String password, String message) throws InterruptedException {

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        signUpButton.click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),message);
        alert.accept();
    }
}
