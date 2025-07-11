package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IntroToIframe {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement textToGet = driver.findElement(By.xpath("//div[@id='frame1Wrapper']/preceding-sibling::div"));
        System.out.println(textToGet.getText());

        driver.switchTo().frame("frame1");

        WebElement textInsideIframe = driver.findElement(By.tagName("h1"));
        System.out.println(textInsideIframe.getText());

        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();



    }
}
