package com.qa.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlazeMainPage {
    public BlazeMainPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#signin2")
    WebElement signUpButton;

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> categories;



    public void clickSignUpButton(){
        signUpButton.click();
    }
    public void chooseCategory(String chooseCategory){
        for(WebElement category:categories ) {
            if(category.getText().contains(chooseCategory)){
                category.click();
                break;
            }
        }
    }



}
