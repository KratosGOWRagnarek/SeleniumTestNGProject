package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class Homework3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome");
        driver.get("https://demoqa.com/links");
        Thread.sleep(1000);

        driver.navigate().to("https://demoqa.com/");

        driver.navigate().back();

        Thread.sleep(2000);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement one = driver.findElement(By.linkText("Created"));
        wait.until(ExpectedConditions.elementToBeClickable(one));


        clickAndCheckStatus(driver, "Created", "201");
        clickAndCheckStatus(driver, "No Content", "204");
        clickAndCheckStatus(driver, "Moved", "301");
        clickAndCheckStatus(driver, "Bad Request", "400");
        clickAndCheckStatus(driver, "Unauthorized", "401");
        clickAndCheckStatus(driver, "Forbidden", "403");
        clickAndCheckStatus(driver, "Not Found", "404");

        driver.quit();
    }

    public static void clickAndCheckStatus(WebDriver driver, String linkText, String expectedStatus) throws InterruptedException {
        driver.findElement(By.linkText(linkText)).click();
        Thread.sleep(3000);

        String response = driver.findElement(By.cssSelector("#linkResponse")).getText();
        System.out.println(response);

        boolean statusMatch = response.contains(expectedStatus);
        System.out.println("Check for " + expectedStatus + " = " + statusMatch);
        Thread.sleep(2000);
    }
}











