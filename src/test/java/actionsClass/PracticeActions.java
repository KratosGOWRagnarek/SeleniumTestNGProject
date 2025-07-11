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
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PracticeActions {
    @Test
    public void task1() throws InterruptedException {
       /*
        TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links) and validate size is 22
      */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        String firstPageWindowHandle = driver.getWindowHandle(); // D3B76A95F776E9AEFE6CB69AF8000125

        WebElement pavilion = driver.findElement(By.xpath("//a[contains(text(), 'Pavilion')]"));
        pavilion.click();

//        Set<String> windowHandles = driver.getWindowHandles();
//
//        for (String window : windowHandles) {
//            if (!window.equals(firstPageWindowHandle)) {
//                driver.switchTo().window(window);
//            }
//        }
        BrowserUtils.switchWindow(driver,"qavalidation");

        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='primary-menu']//span[.='Selenium' and @class='menu-text']")));

        WebElement seleniumPart = driver.findElement(By.xpath("//ul[@id='primary-menu']/li[2]/a"));
        actions.moveToElement(seleniumPart).perform();
        Thread.sleep(500);
        WebElement python = driver.findElement(By.xpath("//ul[@id='primary-menu']//li//span[@class='menu-item-text']//span[.='Selenium-Python']"));
        python.click();
        List<WebElement> allLinks = driver.findElements(By.xpath("//p/a"));

        int actualSize = allLinks.size();
        int expectedSize = 22;

        Assert.assertEquals(actualSize, expectedSize);

        for (WebElement link : allLinks) {
            System.out.println(link.getDomAttribute("href"));


        }
    }
    @Test
    public void task2(){
        /*
        TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links) and validate size is 22
      */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame1");
        String firstWindowHandle = driver.getWindowHandle();
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles){
            if (!window.equals(firstWindowHandle)){
                driver.switchTo().window(window);
            }
        }


        WebElement headerArchives = driver.findElement(By.xpath("//h1"));
        headerArchives.getText();
        Assert.assertEquals("Category Archives: SeleniumTesting",headerArchives.getText());
        List<WebElement> name = driver.findElements(By.xpath("//h3//a"));
        for (WebElement webElement : name) {
            System.out.println(webElement.getText());


        }
        Assert.assertEquals(name.size(),9);


    }

    @Test
    public void task3(){
        /*
        TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links) and validate size is 22
      */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("");

    }
}
