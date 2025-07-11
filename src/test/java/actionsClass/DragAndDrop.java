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

public class DragAndDrop {


    @Test
    public void practice(){
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
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));

        String actualText=orangeBox.getText(); //before DragAndDrop
        String expectedText="... Or here.";
        Assert.assertEquals(actualText,expectedText);

        actions.dragAndDrop(blueCircle,orangeBox).perform();
        //Reassign the orange Box
        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        actualText=orangeBox.getText(); //after DragAndDrop
        expectedText="You did great!";
        Assert.assertEquals(actualText,expectedText);
        //238, 111, 11
        String actualColor=orangeBox.getCssValue("background-color"); //It validates the background-color
        String expectedColor="rgba(238, 111, 11, 1)";

        Assert.assertEquals(actualColor,expectedColor);


    }

    @Test
    public void task1 () throws InterruptedException {
         /*
1-navigate to the website
2-Validate the box text is "Drop here"
3-Drag and Drop the "Drag me" Box
4-Validate the text changed to "Dropped!"
5-Color changed to navy blue.(rgba(70, 130, 180, 1))
 */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement draggable=driver.findElement(By.cssSelector("#draggable"));

        WebElement dropHere=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));

        String actualText=dropHere.getText(); //BEFORE DRAG-DROP
        String expectedText="Drop here";
        Assert.assertEquals(actualText,expectedText);

        Actions actions=new Actions(driver);

        actions.dragAndDrop(draggable,dropHere).perform();

        actualText=dropHere.getText(); //AFTER DRAG-DROP
        expectedText="Dropped!";
        Assert.assertEquals(actualText,expectedText);

        String actualColor=dropHere.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }
}
