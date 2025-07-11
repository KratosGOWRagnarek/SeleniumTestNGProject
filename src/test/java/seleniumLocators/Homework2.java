package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;
import java.util.Set;


public class Homework2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = Driver.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.cssSelector("#login-button"));
        login.click();

        Thread.sleep(3000);
        List<WebElement> card = driver.findElements(By.cssSelector("button.btn_inventory"));
        for (WebElement element : card) {
            element.click();
        }


        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();

        boolean cartTitlePresent = driver.getPageSource().contains("Your Cart");
        boolean qtyPresent = driver.getPageSource().contains("QTY");
        boolean descPresent = driver.getPageSource().contains("Description");

        if (cartTitlePresent && qtyPresent && descPresent) {
            System.out.println("Cart page text verified.");
        } else {
            System.out.println("Failed.");
        }

        driver.findElement(By.cssSelector("button[data-test='remove-sauce-labs-fleece-jacket']")).click();


        driver.findElement(By.cssSelector("button[data-test='checkout']")).click();
        driver.findElement(By.cssSelector("input[data-test='firstName']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[data-test='lastName']")).sendKeys("Doe");
        driver.findElement(By.cssSelector("input[data-test='postalCode']")).sendKeys("12345");
        driver.findElement(By.cssSelector("#continue")).click();


        boolean paymentInfoPresent = driver.getPageSource().contains("Payment Information");
        boolean shippingInfoPresent = driver.getPageSource().contains("Shipping Information");
        boolean priceTotalPresent = driver.getPageSource().contains("Price Total");

        if (paymentInfoPresent && shippingInfoPresent && priceTotalPresent) {
            System.out.println("Checkout info text verified.");
        } else {
            System.out.println("Failed.");
        }

        WebElement totalElement = driver.findElement(By.cssSelector(".summary_total_label"));
        String totalText = totalElement.getText();
        if (totalText.contains("86.35")) {
            System.out.println("Total verified.");
        } else {
            System.out.println("Failed: Found " + totalText);
        }


        driver.findElement(By.cssSelector("#finish")).click();

        boolean completeTextPresent = driver.getPageSource().contains("Checkout: Complete!");

        if (completeTextPresent) {
            System.out.println("Checkout complete message verified.");
        } else {
            System.out.println("Failed.");
        }

        driver.quit();
    }



    }




