package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/salim/Downloads/codeWiseWebsite.html");

        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement box : boxes) {
            if (box.isDisplayed()&&box.isEnabled()&& !box.isSelected())
            { box.click();
            Thread.sleep(3000); }

            }

        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> links = driver.findElements(By.xpath("//li//a[@href]/.."));
        int counter = 0;
        for (WebElement link : links) {
            System.out.println(link.getText());
            counter++;

        }

        System.out.println(" Number of Lists = " + counter);
        int count = 0;
        for (WebElement link : links) {
            if (link.getText().length()>=12) {
                System.out.println(link.getText());
                count++;}
        }
        System.out.println(count);
    } }

