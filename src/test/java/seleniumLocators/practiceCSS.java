package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceCSS {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Faker faker = new Faker();
        driver.get("https://demoqa.com/text-box");
        WebElement name = driver.findElement(By.cssSelector("input#userName"));
        name.sendKeys(faker.name().firstName());
        WebElement mail = driver.findElement(By.cssSelector("input#userEmail"));
        mail.sendKeys("adas@gmail.com");
        WebElement adress = driver.findElement(By.cssSelector("textarea#currentAddress"));
        adress.sendKeys(faker.address().buildingNumber());
        WebElement permad = driver.findElement(By.cssSelector("textarea#permanentAddress"));
        permad.sendKeys(faker.address().buildingNumber());
        WebElement submit = driver.findElement(By.cssSelector("button#submit"));
        submit.click();
        WebElement check = driver.findElement(By.cssSelector("p#name"));
        if (check.isDisplayed()){
            System.out.println("good");}
        driver.quit();
    }

}
