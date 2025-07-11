package seleniumLocators;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathMethods {
    public static void main(String[] args) throws InterruptedException {
        Faker faker = new Faker();
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchBar = driver.findElement(By.xpath("//input[contains(@id, 'sear')]"));
        searchBar.sendKeys("pants" + Keys.ENTER);
        Thread.sleep(2000);
        WebElement pantsSize = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant ')]/../..//div[text()='32']"));
        pantsSize.click();

        WebElement pantsColor = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant ')]/../../..//div[@aria-label='Black']"));
        pantsColor.click();
        Thread.sleep(3000);


        WebElement addtoCartButton = driver.findElement(By.xpath("//a[contains(text(), 'Caesar Warm-Up Pant ')]/../../..//button[@title='Add to Cart']"));
        addtoCartButton.click();

        Thread.sleep(5000);
        WebElement goToCart = driver.findElement(By.xpath("//a[contains(text(), 'shopping cart')]"));
        goToCart.click();

        WebElement proceed = driver.findElement(By.xpath("//li[@class='item']/button "));
        proceed.click();
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[ @class='input-text' and @type='email' and @id='customer-email' and contains(@data-bind, 'emailFocused')]"));
        email.click();
        email.sendKeys("sam@gmail.com");
        Thread.sleep(2000);

        WebElement name = driver.findElement(By.xpath("//input[@class='input-text' and contains(@data-bind, 'inputName') and @name='firstname']"));
        name.click();
        name.sendKeys(faker.name().firstName());

        WebElement lastname = driver.findElement(By.xpath("//input[@class='input-text' and contains(@data-bind, 'inputName') and @name='lastname']"));
        lastname.sendKeys(faker.name().lastName());

        WebElement company = driver.findElement(By.xpath("//input[@class='input-text' and contains(@data-bind, 'inputName') and @name='company']"));
        company.sendKeys("Code");

        WebElement street = driver.findElement(By.xpath("//input[@class='input-text' and contains(@data-bind, 'inputName') and contains(@name, 'street[0]')]"));
        street.sendKeys(faker.address().streetAddress());
        WebElement city = driver.findElement(By.xpath("//input[@class='input-text' and contains(@data-bind, 'inputName') and @name='city']"));
        city.sendKeys(faker.country().capital());
        WebElement region = driver.findElement(By.xpath("//select[@class='select' and @name='region_id']"));
        region.sendKeys("Alabama");
        WebElement postcode = driver.findElement(By.xpath("//input[@name='postcode']"));
        postcode.sendKeys("60620");
        WebElement phone = driver.findElement(By.xpath("//input[@class='input-text' and contains(@data-bind, 'inputName') and @name='telephone']"));
        phone.sendKeys(faker.phoneNumber().phoneNumber());

        WebElement flat = driver.findElement(By.xpath("//td/input[@type='radio' and @value='flatrate_flatrate']"));
        flat.click();
        WebElement next = driver.findElement(By.xpath("//button[@class='button action continue primary']"));
        next.click();
        Thread.sleep(3000);
        WebElement place = driver.findElement(By.xpath("//button[@class='action primary checkout']"));
        place.click();
        Thread.sleep(3000);
        WebElement validate = driver.findElement(By.xpath("//span[contains(text(), 'Thank')]"));
        String valid = validate.getText();
        String expect = "Thank you for your purchase!";
        System.out.println(valid.equals(expect)? " yes" : "no");
        driver.quit();










        //FINISH CHECKOUT PROCESS using xpath axes, and logical operators
        //verify "Thank you for your purchase!" isDisplayed




    }
}
