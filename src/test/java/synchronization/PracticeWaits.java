package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PracticeWaits {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--host-resolver-rules=MAP *.doubleclick.net 127.0.0.1, MAP *.googlesyndication.com 127.0.0.1");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement name = driver.findElement(By.cssSelector("#firstName"));
        name.sendKeys("Sam");
        WebElement lastname = driver.findElement(By.cssSelector("#lastName"));
        lastname.sendKeys("Av");
        WebElement mail= driver.findElement(By.cssSelector("#userEmail"));
        mail.sendKeys("sas@gmail.com");
        WebElement male = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        male.click();
        WebElement number= driver.findElement(By.cssSelector("#userNumber"));
        number.sendKeys("7777777777");
        WebElement date= driver.findElement(By.cssSelector("#dateOfBirthInput"));
        date.click();

        WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select select = new Select(month);
        select.selectByVisibleText("January");

        WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select selectyear = new Select(year);
        selectyear.selectByValue("1920");

        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Choose Tuesday, January 20th, 1920']"));
        day.click();
        WebElement subjectInput = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__input']/input"));
        subjectInput.sendKeys("C");
        Thread.sleep(2000);

        WebElement compScie = driver.findElement(By.xpath("//div[.='Computer Science']"));
        compScie.click();

        WebElement hobbies = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        hobbies.click();

        WebElement file = driver.findElement(By.id("uploadPicture"));
        file.sendKeys("C:/Users/salim/OneDrive/Desktop/html/usa.png");

        WebElement address = driver.findElement(By.tagName("textarea"));
        address.sendKeys("3237 n M");


        WebElement stateoption= driver.findElement(By.cssSelector("#state"));
        stateoption.click();
        Thread.sleep(2000);
        WebElement state = driver.findElement(By.cssSelector("#react-select-3-option-3"));
        Thread.sleep(2000);
        state.click();

        WebElement cityoption= driver.findElement(By.cssSelector("#city"));
        cityoption.click();
        Thread.sleep(2000);
        WebElement city = driver.findElement(By.cssSelector("#react-select-4-option-1"));
        Thread.sleep(2000);
        city.click();

        WebElement submit = driver.findElement(By.cssSelector("#submit"));
        submit.click();








    }
}
