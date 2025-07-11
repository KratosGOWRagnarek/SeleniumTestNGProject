package jsMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class javaScriptMethodsPractice {

    @Test
    public void practice(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codewise.academy/");

        WebElement watchVideo = driver.findElement(By.linkText("Watch Presentation"));
        //watchVideo.click();// if it does not work
        Actions actions= new Actions(driver);
        //actions.click(watchVideo).perform();// if it does not work
        // Last option

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",watchVideo);

    }

    @Test
    public void practicejs(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yes = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        //yes.click();

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()",yes);
        BrowserUtils.clickJS(driver,yes);
        WebElement validate = driver.findElement(By.cssSelector(".mt-3"));
        Assert.assertEquals(validate.getText(),"You have selected Yes");


    }

    @Test
    public void scrollIntoViewPractice() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://codewise.academy/");

        WebElement instructor = driver.findElement(By.xpath("//div[.='Isa']"));
       // JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true)",instructor);

        BrowserUtils.scrollWithJS(driver,instructor);
        Thread.sleep(2000);
        WebElement it = driver.findElement(By.xpath("//div[contains(text(),'Start')]"));
       // js.executeScript("arguments[0].scrollIntoView(true)",it);
        BrowserUtils.scrollWithJS(driver,it);
    }

    @Test
    public void practiceScroll() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button3=driver.findElement(By.cssSelector("#newWindowsBtn"));
        BrowserUtils.scrollWithJS(driver,button3);
        Thread.sleep(2000);
        button3.click();
    }
}
