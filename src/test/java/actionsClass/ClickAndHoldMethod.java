package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClickAndHoldMethod {
    @Test
    public void practice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement acceptCookies=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        wait.until(ExpectedConditions.visibilityOf(acceptCookies));

        Actions actions=new Actions(driver);
        actions.click(acceptCookies).perform();
        //This scrolls the element with pixel (zoom in,zoom out)
        actions.scrollByAmount(300,300).perform();

        WebElement blueCircle=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox=driver.findElement(By.xpath("//div[@class='test1']"));

        String actualText = blueBox.getText();
        String expectedText = "Drag the small circle here ...";
        Assert.assertEquals(actualText,expectedText);

        actions.clickAndHold(blueCircle).moveToElement(blueBox).release().perform();
        blueBox=driver.findElement(By.xpath("//div[@class='test1']"));
        actualText = blueBox.getText();
        expectedText="You did great!";
        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void validateFunc() throws InterruptedException {
        /*
1-Navigate to the website
  -->Click Accept Button with actions.click(Accept).perform
2-Validate the text is Box text is "Drop here"
3-Click and Hold Not acceptable box and release into Box
4-Validate the box text is still "Drop here"
5-Click and Hold Acceptable box and release into Box
6-Validate box text is "Dropped!"

 */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement accept = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        Actions actions = new Actions(driver);
        actions.click(accept).perform();
        Thread.sleep(5000);
        WebElement drop = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        Assert.assertEquals(drop.getText(),"Drop here");

        WebElement NotAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        actions.clickAndHold(NotAcceptable).moveToElement(drop).release().perform();
        //Thread.sleep(2000);
        drop = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        Assert.assertEquals(drop.getText(),"Drop here");

        WebElement Acceptable = driver.findElement(By.cssSelector("#acceptable"));
        actions.clickAndHold(Acceptable).moveToElement(drop).release().perform();
        //Thread.sleep(2000);
        drop = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        Assert.assertEquals(drop.getText(),"Dropped!");





    }

}
