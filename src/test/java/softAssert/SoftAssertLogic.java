package softAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class SoftAssertLogic {

    public int sum(int number1, int number2) {
        return number1 + number2;
    }

    @Test
    public void hardAssert() {
        Assert.assertEquals(sum(5, 6), 11);
        System.out.println("I am test 1");
        Assert.assertEquals(sum(1, 3), 5); //when it fails, it stops the execution
        System.out.println("I am test 2");
        Assert.assertEquals(sum(0, 7), 7);
        System.out.println("I am test 3");

    }

    @Test
    public void softAssert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sum(5, 6), 11);
        System.out.println("I am test 1");
        softAssert.assertEquals(sum(1, 3), 5);
        System.out.println("I am test 2");
        softAssert.assertEquals(sum(0, 7), 7);
        System.out.println("I am test 3");
        softAssert.assertEquals(sum(0, 7), 7);
        System.out.println("I am test 3");
        softAssert.assertEquals(sum(0, 8), 7);
        System.out.println("I am test 3");
        softAssert.assertAll();
    }


    @Test
    public void validateProductInformation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        Thread.sleep(5000);
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
//        Assert.assertEquals(allProducts.size(),7);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(allProducts.size(), 7);
        for (WebElement product : allProducts) {

            if (product.getText().equals("Sauce Labs Bolt T-Shirt")) {
                product.click();
                break;
            }
        }
        WebElement header = driver.findElement(By.cssSelector(".inventory_details_name"));
        //I took the left side of the class value (because of the space
        String actualHeader = header.getText();
        String expectedHeader = "Sauce Labs Bolt T-Shirt";
        Assert.assertEquals(actualHeader, expectedHeader);

        WebElement desc = driver.findElement(By.xpath("//div[@data-test='inventory-item-desc']"));

        String actualDesc = desc.getText();
        String expectedDesc = "heather gray";
        Assert.assertTrue(actualDesc.contains(expectedDesc));

        WebElement price = driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"));

        String actualPrice = price.getText();
        String expectedPrice = "$15.99";
        Assert.assertEquals(actualPrice, expectedPrice);

        WebElement addToCartButton = driver.findElement(By.cssSelector("#add-to-cart"));
        Assert.assertTrue(addToCartButton.isDisplayed());
        softAssert.assertAll();
        /*
1-Navigate to website https://www.saucedemo.com/
2-Login Successfully with username and password
3-Store all the elements and validate there are 6 items on the website (list.size method might help)
4-Loop through all items and once this element name is "Sauce Labs Bolt T-Shirt" then click and break
5-Validate the header "Sauce Labs Bolt T-Shirt"
6-Validate the description contains(heather gray)
7-Validate the price "$15.99"
8-Validate the Add to card is displayed and enabled on the page.
9-Quit
*/
    }
}