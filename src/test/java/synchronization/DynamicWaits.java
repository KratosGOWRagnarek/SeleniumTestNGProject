package synchronization;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicWaits {
    @Test
    public void implicitWaitSyntax(){
        WebDriver driver = new ChromeDriver();
        //waits for elements to appear on page before throwing NOSuchElementException
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //waits for the page load to complete
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


    }
    @Test
    public void explicitWaitSyntax(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement element = driver.findElement(By.id("ccx"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("dsfsdf")));
        WebElement element2=driver.findElement(By.id("dsfsdf"));
        element2.click();

    }
    @Test
    public void fluentWaitSyntax(){
        WebDriver driver = new ChromeDriver();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // total timeout
                .ignoring(NoSuchElementException.class) // ignoring exception
                .ignoring(StaleElementReferenceException.class) //ignoring exception
                .pollingEvery(Duration.ofSeconds(1));// how often do we want to check the condition

        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("dklfngblkfb")));

    }

}
