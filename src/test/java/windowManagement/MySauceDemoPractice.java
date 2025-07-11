package windowManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class MySauceDemoPractice {
   /* 1. go to https://www.saucedemo.com/
            2. login
3. click on Twitter icon
4. print title and url of Twitter
5. come back to the main page
6. click on Facebook icon
7. print title and url of Facebook
8. come back to the main page
9. click on Linkedin icon
}*/
    @Test
    public void mytest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement submitButton = driver.findElement(By.cssSelector("#login-button"));
        submitButton.click();
        Thread.sleep(2000);
        String mainPage = driver.getWindowHandle();

        WebElement twitter = driver.findElement(By.xpath("//a[.='Twitter']"));
        twitter.click();
        Set<String> allPages = driver.getWindowHandles();
        for (String Page : allPages) {
            if (!Page.equals(mainPage)){
                driver.switchTo().window(Page);
            }


        }
        WebElement twiTitle = driver.findElement(By.xpath("//h2[.='Sauce Labs']"));
        String twitPage= driver.getWindowHandle();
        Assert.assertEquals(twiTitle.getText(),"Sauce Labs");
        String twitUrl = driver.getCurrentUrl();
        Assert.assertEquals(twitUrl,"https://x.com/saucelabs");

        driver.switchTo().window(mainPage);
        WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebook.click();
        allPages = driver.getWindowHandles();
        for (String Page : allPages) {
            if (!Page.equals(mainPage) && !Page.equals(twitPage)){
                driver.switchTo().window(Page);
            }

        }


        Thread.sleep(2000);
        WebElement facetitile = driver.findElement(By.xpath("//div[@class='x1xka2u1 xqfms19']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xg8j3zb']"));
        Assert.assertEquals(facetitile.getText(),"See more from Sauce Labs");
        String facebookP = driver.getWindowHandle();

        driver.switchTo().window(mainPage);
        WebElement link = driver.findElement(By.xpath("//a[.='LinkedIn']"));
        BrowserUtils.clickJS(driver,link);
        BrowserUtils.switchWindow(driver,"LinkedIn");
//        allPages = driver.getWindowHandles();
//
//        for (String Page : allPages) {
//            if (!Page.equals(mainPage) && !Page.equals(twitPage)&& !Page.equals(facebookP)){
//                driver.switchTo().window(Page);
//            }
//
//        }
        String linkUrl=driver.getCurrentUrl();
        Assert.assertEquals(linkUrl,"https://www.linkedin.com/company/sauce-labs/");
        //driver.quit();














    }


@Test
public void task() throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");


// login part

    WebElement username = driver.findElement(By.cssSelector("#user-name"));
    username.sendKeys("standard_user");
    WebElement password = driver.findElement(By.cssSelector("#password"));
    password.sendKeys("secret_sauce");
    WebElement submitButton = driver.findElement(By.cssSelector("#login-button"));
    submitButton.click();
    Thread.sleep(1000);

// twitter part

    WebElement twitter = driver.findElement(By.xpath("//a[.='Twitter']"));
    twitter.click();
    Thread.sleep(3000);

// window handle part
    String firstPage = driver.getWindowHandle();
    Set<String> windows = driver.getWindowHandles();

    for (String window : windows ) {
        if(!window.equals(firstPage)) {
            driver.switchTo().window(window);
        }
    }

    System.out.println("driver.getTitle() = " + driver.getTitle());
    System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    driver.close();
    Thread.sleep(3000);

// come back to first page

    driver.switchTo().window(firstPage);
    Thread.sleep(3000);

    System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

// facebook part

    WebElement facebook = driver.findElement(By.xpath("//a[.='Facebook']"));
    facebook.click();
    Thread.sleep(3000);

    windows.clear();
    firstPage = driver.getWindowHandle();
    windows = driver.getWindowHandles();

    for (String window : windows ) {
        if(!window.equals(firstPage)) {
            driver.switchTo().window(window);
        }
    }

    System.out.println("driver.getTitle() = " + driver.getTitle());
    System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    driver.close();

// come back to first page

    driver.switchTo().window(firstPage);
    System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

// Linkedin part

    WebElement linkedin = driver.findElement(By.xpath("//a[.='LinkedIn']"));
    linkedin.click();

    windows.clear();
    windows = driver.getWindowHandles();

    for (String window : windows ) {
        if(!window.equals(firstPage)) {
            driver.switchTo().window(window);
        }
    }

    System.out.println("driver.getTitle() = " + driver.getTitle());
    System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    Thread.sleep(3000);
    driver.quit();



}
}
