package exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingPopup {

    @Test
    public void testSmallModalPopup() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/modal-dialogs");

        WebElement smallModel = driver.findElement(By.id("showSmallModal"));
        smallModel.click();

        Thread.sleep(1000);

        try {
            WebElement largeModal = driver.findElement(By.id("showLargeModal"));
            largeModal.click();
        }
        catch (ElementClickInterceptedException e){
            e.printStackTrace();
//            System.out.println(e.getMessage());
            driver.findElement(By.id("closeSmallModal")).click();
            WebElement largeModal = driver.findElement(By.id("showLargeModal"));
            largeModal.click();
        }

    }
}
