package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class IntroToCss {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Faker faker = new Faker();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement name = driver.findElement(By.cssSelector("input[id='user-name']"));
        name.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("input[placeholder = 'Password']"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        String url = driver.getCurrentUrl();
        if (url.contains("inventory")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        WebElement backpack = driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']"));
        backpack.click();
        Thread.sleep(3000);
        WebElement tshirt = driver.findElement(By.cssSelector("button[id = 'add-to-cart-sauce-labs-bolt-t-shirt'"));
        tshirt.click();
        Thread.sleep(3000);
        WebElement card = driver.findElement(By.cssSelector("a[class='shopping_cart_link']"));
        card.click();
        Thread.sleep(3000);
        WebElement checkout = driver.findElement(By.cssSelector("button[id='checkout']"));
        checkout.click();
        Thread.sleep(3000);
        WebElement namefill = driver.findElement(By.cssSelector("input[id='first-name']"));
        namefill.sendKeys("Sam");
        Thread.sleep(3000);
        WebElement lastnamefill = driver.findElement(By.cssSelector("input[id='last-name']"));
        lastnamefill.sendKeys(faker.name().lastName());
        Thread.sleep(3000);
        WebElement zip = driver.findElement(By.cssSelector("input[id='postal-code']"));
        zip.sendKeys("60600");
        Thread.sleep(3000);
        WebElement continuebutton = driver.findElement(By.cssSelector("input[id='continue']"));
        continuebutton.click();
        Thread.sleep(3000);
        WebElement finish = driver.findElement(By.cssSelector("button[id='finish']"));
        finish.click();
        Thread.sleep(3000);
        WebElement check = driver.findElement(By.cssSelector("h2[class='complete-header']"));
        if (check.isDisplayed()) {
            System.out.println("Pass");
        }
        driver.quit();





    }



}

