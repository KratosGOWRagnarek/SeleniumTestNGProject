package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/salim/Downloads/codeWiseWebsite.html");

        //Locator ID
        WebElement header = driver.findElement(By.id("codewise1"));
        String actualHeader= header.getText();
        String expectedHeader = "CodeWise Academy";
        System.out.println(actualHeader.equals(expectedHeader)?"Header is passed" : "Header is failed");

        //TASK locate ID
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());


        //locate name
        WebElement firstname = driver.findElement(By.name("firstName"));
        firstname.sendKeys("Salim");
        WebElement lastname = driver.findElement(By.name("lastName"));
       lastname.sendKeys("Aryanov");
       WebElement phone = driver.findElement(By.name("phone"));
       phone.sendKeys("7087568426");
       WebElement email = driver.findElement(By.name("userName"));
       email.sendKeys("salim.aryanov@gmail.com");
       WebElement adress = driver.findElement(By.name("address1"));
       adress.sendKeys("3237 Major");
       WebElement city = driver.findElement(By.name("city"));
       city.sendKeys("Chicago");
       WebElement state = driver.findElement(By.name("state"));
       state.sendKeys("IL");
       WebElement pc = driver.findElement(By.name("postalCode"));
       pc.sendKeys("60634");

     //locator class
       WebElement alltools = driver.findElement(By.className("group_checkbox"));
        System.out.println("alltools = " + alltools.getText());

        WebElement javabox = driver.findElement(By.id("cond1"));
        if(javabox.isDisplayed()&&javabox.isEnabled()&& !javabox.isSelected()){
            javabox.click();
        }
        WebElement NGbox = driver.findElement(By.id("cond3"));
        if(NGbox.isDisplayed()&&NGbox.isEnabled()&& !NGbox.isSelected()){
            NGbox.click();
        }
        WebElement cucumber =driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed()&& cucumber.isEnabled()&&! cucumber.isSelected()){
            cucumber.click();
        }
        Thread.sleep(3000);
        driver.quit();

    }
}
