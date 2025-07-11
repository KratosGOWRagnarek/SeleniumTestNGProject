package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractice2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement appointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appointment.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement login = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login.click();
        Thread.sleep(5000);
        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement apply = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (apply.isDisplayed()&& ! apply.isSelected()){apply.click();}
        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();
        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("15/04/2025");
        WebElement message = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        message.sendKeys("I love Selenium");
        WebElement book = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        book.click();
        WebElement validateApp = driver.findElement(By.xpath("//h2[contains(text(),'Appointment')]"));
        String Actual = validateApp.getText();
        String Expected = "Appointment Confirmation";
        System.out.println(Actual.equals(Expected) ? "Passed" : "Failed");
        WebElement facilityInfo = driver.findElement(By.xpath("//p[@id='facility']"));
        System.out.println(facilityInfo.getText());
        WebElement applyForHospitalInfo = driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
        System.out.println(applyForHospitalInfo.getText());
        WebElement healthcareProgramInfo = driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(healthcareProgramInfo.getText());
        WebElement visitDateInfo = driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(visitDateInfo.getText());
        WebElement commentInfo = driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(commentInfo.getText());
        WebElement goHomeButton = driver.findElement(By.xpath("//a[@class='btn btn-default']"));
        goHomeButton.click();
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(currentURL.equals(expectedURL) ? "URL Passed" : "URL failed");
        driver.quit();









    }
}
