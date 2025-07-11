package checkboxesAndRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PracticeHeroku {
    /*
1. go to https://the-internet.herokuapp.com/checkboxes
2. verify checkbox2 is selected using Assert
3. select checkbox1
4. verify checkbox1 is selected using Assert
 */
    @Test
    public void task() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@checked]"));
        Assert.assertTrue(checkbox2.isSelected());
        WebElement checkbox1 = driver.findElement(By.xpath("//form/input/preceding::input"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());


    }

    @Test
    public void task2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        Thread.sleep(1000);
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        Thread.sleep(1000);
        password.sendKeys("admin123");
        WebElement login = driver.findElement(By.xpath("//button[.=' Login ']"));
        login.click();
        Thread.sleep(1000);
        WebElement recruitment = driver.findElement(By.xpath("//span[.='Recruitment']"));
        recruitment.click();
        Thread.sleep(3000);
       WebElement checkhoose = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div[1]//label"));
        checkhoose.click();

    }
}
