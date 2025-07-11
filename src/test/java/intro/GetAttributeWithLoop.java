package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GetAttributeWithLoop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        WebElement close = driver.findElement(By.xpath("//button"));
        close.click();
        List<WebElement> lists = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (WebElement list : lists) {
            if (list.getDomAttribute("aria-checked").equals("false")) {
                list.click();
            }

        }
}
}
