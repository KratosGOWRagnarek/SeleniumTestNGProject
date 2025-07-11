package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class SelectPracticeFinal {
    @Test
    public void validateFilterSearchFunctionality(){
       // WebDriver driver = Driver.getDriver("chrome");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/shopping/");
                /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website https://www.cars.com/shopping/
2-Choose the "New & certified" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX 350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
6-Choose the distance 40 miles
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8- zipCode.sendKeys(60018, Keys.ENTER);
9-Validate the header contains  "New and certified used Lexus RX 350 for sale"
11-Validate the all titles has Lexus RX 350

NOTE:If the cookies blocking you, please click Accept All Cookies button
NOTE:If there is an advertisement, just refresh the page with automation
 */
        WebElement acceptCookies = driver.findElement(By.xpath("//button[.='Accept all cookies']"));
        acceptCookies.click();

        WebElement newAndCertified=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(newAndCertified,"New & certified","text");

        WebElement makes = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(makes,"Lexus","text");

        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");


        WebElement validateOption = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select select = new Select(validateOption);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"No max price");

        WebElement miles = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(miles,"40","value");

        WebElement zip = driver.findElement(By.cssSelector("#make-model-zip"));
        zip.clear();
        zip.sendKeys("60634", Keys.ENTER);

        WebElement header = driver.findElement(By.xpath("//h1"));
        String head = header.getText();
        Assert.assertTrue(head.contains("New and certified used Lexus RX 350 for sale"));

        List<WebElement> allTitles = driver.findElements(By.xpath("//h2[@class='title']"));
        for (WebElement allTitle : allTitles) {
            Assert.assertTrue(allTitle.getText().contains("Lexus RX 350"));


        }


        driver.quit();

    }
}
