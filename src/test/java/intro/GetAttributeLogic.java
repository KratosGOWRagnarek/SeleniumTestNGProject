package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttributeLogic {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement text = driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(text.getDomAttribute("value"));
        System.out.println(text.getDomAttribute("placeholder"));

    }
}
