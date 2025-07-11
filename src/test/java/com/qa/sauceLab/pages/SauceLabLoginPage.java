package com.qa.sauceLab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SauceLabLoginPage {
    public SauceLabLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "user-name")
    WebElement name;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;


    public void loginFunctionality( String name, String password){
        this.name.sendKeys(name);
        this.password.sendKeys(password);
        loginButton.click();


    }

    public void titlesAndContains(WebDriver driver, String header,String text, String price){


        List<WebElement> Itemslist = driver.findElements(By.className("inventory_item_name"));
        Assert.assertEquals(Itemslist.size(), 6);


        for (WebElement item : Itemslist) {
            if (item.getText().equals(header)) {
                break;

        }
            Assert.assertTrue(item.isDisplayed());

    }

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        Assert.assertEquals(Itemslist.size(), 6);


        for (WebElement p : prices) {
            if (p.getText().contains(price)) {
                break;
            }
            Assert.assertTrue(p.isDisplayed());

        }
        List<WebElement> texts = driver.findElements(By.xpath("//div[@data-test='inventory-item-desc']"));
        Assert.assertEquals(Itemslist.size(), 6);


        for (WebElement piece : texts) {
            if (piece.getText().contains(text)) {
                break;
            }
            Assert.assertTrue(piece.isDisplayed());

        }


    }


    }






