package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://formy-project.herokuapp.com/form");
        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("//input[@id='first-name']"));
        name.sendKeys(faker.name().firstName());
        WebElement lastname = driver.findElement(By.xpath("//input[@id='last-name']"));
        lastname.sendKeys(faker.name().lastName());
        WebElement job = driver.findElement(By.xpath("//input[@id='job-title']"));
        job.sendKeys(faker.job().position());
        WebElement college = driver.findElement(By.xpath("//input[@id='radio-button-2']"));
        college.click();
        Thread.sleep(3000);
        WebElement male = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
        if (male.isDisplayed()& male.isEnabled()&!male.isSelected()) {male.click();}
        Thread.sleep(3000);
        WebElement year = driver.findElement(By.xpath("//select[@id='select-menu']"));
        year.sendKeys("5-9");
        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("04/15/2025");
        WebElement submitButton = driver.findElement(By.xpath("//a[@role='button']"));
        submitButton.click();
        WebElement validateHeader = driver.findElement(By.xpath("//h1[contains(text(), 'Thanks')]"));
        String actualHeader = validateHeader.getText();
        String expectedHeader ="Thanks for submitting your form";
        System.out.println(actualHeader.equals(expectedHeader)?"true":"false");
        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(), 'form')]"));
        String message= validateMessage.getText();
        String expectedMessage = "The form was successfully submitted!";
        System.out.println(message.equals(expectedMessage)?"true":"false");

        driver.quit();



    }
}
