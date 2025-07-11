package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//waits 10 seconds for elements
        driver.get("file:///C:/Users/salim/Downloads/codeWiseWebsite.html");

        //LOCATOR TAGNAME
        WebElement javaversion  = driver.findElement(By.tagName("u"));
        System.out.println(javaversion.getText());

        // LOCATOR LINKTEXT
        WebElement JAVALINK = driver.findElement(By.linkText("Java"));
        JAVALINK.click();


     //task
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText());
        Thread.sleep(2000);

        driver.navigate().back();
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        Thread.sleep(2000);


        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText());
        Thread.sleep(2000);


        driver.navigate().back();
        WebElement repeat = driver.findElement(By.tagName("h1"));
        System.out.println("repeat = " + repeat.getText());

        //LOCATOR PARTIAL-LINKTEXT
        WebElement restApiLink=driver.findElement(By.partialLinkText("Rest"));
        restApiLink.click();
        driver.close();

    }
}
