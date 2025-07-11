package alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeAlerts {
    @Test
    public void deleteCustomer(){
        /*
1. go to https://demo.guru99.com/test/delete_customer.php
2. enter any text, click Submit
3. get text of alert and print it
4. accept alert by clicking ok
5. get text of the new alert and print it
6. accept the alert
 */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        WebElement input = driver.findElement(By.xpath("//input[@name='cusid']"));
        input.sendKeys("SAlim",  Keys.ENTER);
       String text= driver.switchTo().alert().getText();
        System.out.println(text);
        driver.switchTo().alert().accept();
        String text1= driver.switchTo().alert().getText();
        System.out.println(text1);
        driver.switchTo().alert().accept();

    }

    @Test
    public void practiceAlerts(){
        /*
1. go to https://the-internet.herokuapp.com/javascript_alerts
2. click on JS Alert
3. print alert's text
4. accept alert
5. click on JS Confirm
6. print alert's text
7. dismiss alert
8. click on JS Prompt
9. print alert's text
10. send some keys
11. accept alert
 */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alert = driver.findElement(By.xpath("//button[.='Click for JS Alert'] "));
        alert.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm'] "));
        confirm.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        WebElement prompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt'] "));
        prompt.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Sam");
        driver.switchTo().alert().accept();




    }

}
