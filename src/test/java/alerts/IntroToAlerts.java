package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class IntroToAlerts {
    @Test
    public void acceptAlertTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");

        WebElement button = driver.findElement(By.cssSelector("#alertButton"));
        button.click();
        driver.switchTo().alert().accept();



    }
    @Test
    public void dismissAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.cssSelector("#confirmButton"));
        button.click();
        driver.switchTo().alert().dismiss();

    }
    @Test
    public void SendKeysAcceptAlertTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/alerts");

        WebElement button = driver.findElement(By.cssSelector("#promtButton"));
        button.click();
        driver.switchTo().alert().sendKeys("Salim");
        driver.switchTo().alert().accept();

    }
}
