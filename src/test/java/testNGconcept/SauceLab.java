package testNGconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SauceLab {

    @Test
    public void validateHappyPathLogin(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.cssSelector("#login-button"));
        login.click();
        String actualtitle = driver.getTitle();
        String expected = "Swag Labs";
        Assert.assertEquals(actualtitle,expected);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualURL,expectedURL);
        driver.quit();
    }

    @Test
    public void validateLoginErrorMessage(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secrauce");
        WebElement login = driver.findElement(By.cssSelector("#login-button"));
        login.click();
        WebElement errorText = driver.findElement(By.xpath("//h3[@data-test]"));
        Assert.assertEquals(errorText.getText(), "Epic sadface: Username and password do not match any user in this service");

    }


    @Test
    public void homework() throws InterruptedException {
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
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.cssSelector("#login-button"));
        login.click();
        Thread.sleep(3000);
        List<WebElement> Itemslist = driver.findElements(By.className("inventory_item_name"));
        for (WebElement element : Itemslist) {
            System.out.println(element.getText());
        }
        Assert.assertEquals(Itemslist.size(), 6);
        System.out.println(Itemslist);


//        for (WebElement item : Itemslist) {
//            if (item.getText().equals("Sauce Labs Bolt T-Shirt")) {
//                item.click();
//                break;
//            }
//
//        }
//
//        Thread.sleep(2000);
//
//
//        String header = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();
//        Assert.assertEquals(header,"Sauce Labs Bolt T-Shirt");
//
//        String description = driver.findElement(By.xpath("//div//div//div[@data-test='inventory-item-desc']")).getText();
//        Assert.assertTrue(description.toLowerCase().contains("heather gray"));
//
//        String price = driver.findElement(By.xpath("//div//div//div[@data-test='inventory-item-price']")).getText();
//        Assert.assertEquals(price,"$15.99");
//
//        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart"));
//        Assert.assertTrue(addToCartBtn.isDisplayed());
//        Assert.assertTrue(addToCartBtn.isEnabled());
//
//        driver.quit();


        }

        @Test
    public void taskafterhomework() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.saucedemo.com/");
            WebElement username = driver.findElement(By.cssSelector("#user-name"));
            username.sendKeys("standard_user");
            WebElement password = driver.findElement(By.cssSelector("#password"));
            password.sendKeys("secret_sauce");
            WebElement login = driver.findElement(By.cssSelector("#login-button"));
            login.click();
            Thread.sleep(3000);
            List<WebElement> Itemslist = driver.findElements(By.className("inventory_item_name"));
            Assert.assertEquals(Itemslist.size(), 6);


            for (WebElement item : Itemslist) {
                if (item.getText().equals("Sauce Labs Bolt T-Shirt")) {
                    item.click();
                    break;
                }

            }

            Thread.sleep(2000);



            WebElement addToCartBtn = driver.findElement(By.id("add-to-cart"));
            Assert.assertTrue(addToCartBtn.isDisplayed());
            Assert.assertTrue(addToCartBtn.isEnabled());
            addToCartBtn.click();

            WebElement oneCheck = driver.findElement(By.xpath("//span[.='1']"));
            String number = oneCheck.getText();
            Assert.assertTrue(number.contains("1"));

            WebElement cart = driver.findElement(By.cssSelector(".shopping_cart_link"));
            cart.click();

            WebElement name = driver.findElement(By.cssSelector(".inventory_item_name"));
            Assert.assertEquals(name.getText(),"Sauce Labs Bolt T-Shirt");

            WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
            checkout.click();

            WebElement Firstname = driver.findElement(By.cssSelector("#first-name"));
            Firstname.sendKeys("Salim");

            WebElement Lastname = driver.findElement(By.cssSelector("#last-name"));
            Lastname.sendKeys("Aryanov");

            WebElement zip = driver.findElement(By.cssSelector("#postal-code"));
            zip.sendKeys("60000");

            WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
            continueButton.click();

            WebElement totalPrice = driver.findElement(By.xpath("//div[.='Total: $17.27'] "));
            String total = totalPrice.getText();
            Assert.assertTrue(total.contains("17.27"));

            WebElement finish = driver.findElement(By.cssSelector("#finish"));
            finish.click();

            WebElement validateText = driver.findElement(By.xpath("//h2[.='Thank you for your order!']"));
            Assert.assertEquals(validateText.getText(),"Thank you for your order!");
            driver.quit();






        }




    }




