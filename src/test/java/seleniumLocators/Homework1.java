package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com");
        WebElement destination = driver.findElement(By.linkText("destination of the week! The Beach!"));
        destination.click();
        WebElement header = driver.findElement(By.xpath("//div[contains(text(),'Hawaii')]"));
        String actualHeader= header.getText();
      // I could not use className - container because there are 2 of them, and there are no ID and name
        String expectedHeader = "Hawaii";
        System.out.println(actualHeader.contains(expectedHeader)?"Header is passed" : "Header is failed");
        driver.quit();

    }
}
