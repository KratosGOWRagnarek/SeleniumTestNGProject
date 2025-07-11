package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectclassPractice1 {
    @Test
    public void selectmethodsPractice() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/salim/Downloads/codeWiseWebsite.html");

       /*
1-Validate the default value is "UNITED STATES"
2-Choose Your own country with "VisibleText" Method Thread.sleep to see how it is changing
3-Choose your favorite country with "value" method Thread.sleep
4-Choose the country you do not want to visit "index" Thread.sleep
5-Validate the number of countries is 264
6-Print out all the countries
7-driver.quit()
 */
        WebElement optionBox = driver.findElement(By.xpath("//select[@name='country'] "));
        Select select = new Select(optionBox);
        String defaultCountry = select.getFirstSelectedOption().getText();
        String expecteddefault = "UNITED STATES";
        Assert.assertEquals(defaultCountry,expecteddefault);

        Thread.sleep(2000);
        select.selectByVisibleText("KAZAKHSTAN ");
        Thread.sleep(2000);
        select.selectByValue("100");
        Thread.sleep(2000);
        select.selectByIndex(24);

        List<WebElement> alloptions=select.getOptions();
        System.out.println(alloptions.size());
        Assert.assertEquals(alloptions.size(),264);
        for (WebElement Country : alloptions) {
            System.out.println(Country.getText());
        }
        driver.quit();








    }
}
