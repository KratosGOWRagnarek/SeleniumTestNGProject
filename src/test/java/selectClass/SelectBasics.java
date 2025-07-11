package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {
    @Test
    public void selectmethods() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement optionbox = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(optionbox);

        String actualDefault =select.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        Assert.assertEquals(actualDefault,expected);

        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
        select.selectByValue("2");
        Thread.sleep(2000);
        select.selectByIndex(1);

        List<WebElement> allOptions = select.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1","Option 2");

        for (int i = 0; i <allOptions.size() ; i++) {
            Assert.assertEquals(allOptions.get(i).getText(),expectedOptions.get(i));

        }


    }
}
