package checkboxesAndRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckBoxPractice {
    @Test
    public void selectCheckBox(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/checkbox");
        WebElement arrow = driver.findElement(By.xpath("//button[@aria-label='Toggle']"));
        arrow.click();
        WebElement box1 = driver.findElement(By.xpath("//input[@id='tree-node-desktop']/.."));
        box1.click();
        WebElement box2 = driver.findElement(By.xpath("//label[@for='tree-node-documents']"));
        box2.click();
        List<WebElement> results = driver.findElements(By.xpath("//div[@id='result']//span"));
        List<String> testResults = new ArrayList<>();
        for (WebElement result : results) {
            testResults.add(result.getText());
        }
        Assert.assertTrue(testResults.contains("desktop"));
        Assert.assertTrue(testResults.contains("documents"));


        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement radio = driver.findElement(By.xpath("//label[@class='custom-control-label' and @for='yesRadio']"));
        radio.click();
        WebElement radios = driver.findElement(By.cssSelector("#yesRadio"));
        Assert.assertTrue(radios.isSelected());


    }
}
