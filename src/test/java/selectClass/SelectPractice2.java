package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractice2 {
    @Test
    public void validateOrderTravelTicket() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();

        WebElement passengerBox = driver.findElement(By.xpath("//select[@name='passCount']"));

        Select passenger = new Select(passengerBox);
        passenger.selectByValue("4"); //choosing 4 passenger

        WebElement departingFromBox = driver.findElement(By.xpath("//select[@name='fromPort']"));

        Select departingFrom = new Select(departingFromBox);
        String actualDefault = departingFrom.getFirstSelectedOption().getText();
        String expectedDefault = "Acapulco";
        Assert.assertEquals(actualDefault, expectedDefault);

        departingFrom.selectByVisibleText("Paris");

        WebElement fromMonthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));

        Select fromMonth = new Select(fromMonthBox);
        fromMonth.selectByIndex(7);//August

        WebElement fromDayBox = driver.findElement(By.xpath("//select[@name='fromDay']"));

        Select fromDay = new Select(fromDayBox);
        fromDay.selectByValue("15");

        WebElement toPortBox = driver.findElement(By.xpath("//select[@name='toPort']"));

        Select toPort = new Select(toPortBox);
        toPort.selectByValue("San Francisco");

        WebElement toMonthBox = driver.findElement(By.xpath("//select[@name='toMonth']"));

        Select toMonth = new Select(toMonthBox);
        toMonth.selectByVisibleText("December");

        WebElement toDayBox = driver.findElement(By.xpath("//select[@name='toDay']"));

        Select toDay = new Select(toDayBox);
        toDay.selectByVisibleText("15");

        WebElement servicesClasses = driver.findElement(By.xpath("//input[@value='First']"));
        servicesClasses.click();

        WebElement airlinesBox = driver.findElement(By.xpath("//select[@name='airline']"));

        Select airlines = new Select(airlinesBox);

        List<WebElement> allAirlinesOptions = airlines.getOptions();
        List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines",
                "Pangea Airlines");

        for (int i = 0; i < allAirlinesOptions.size(); i++) {
            Assert.assertEquals(allAirlinesOptions.get(i).getText(), expectedOptions.get(i));
        }

        airlines.selectByVisibleText("Unified Airlines");

        Thread.sleep(5000);
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader = header.getText();
        String expectedHeader = "After flight finder - No Seats Available";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

     /*
1-Navigate to the website (https://demo.guru99.com/test/newtours/reservation.php)
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available" (you can use font_size=4 for element location)

 NOTE:Your test should fail
 NOTE2:You can use any select method value,visibleText,index
 */
     @Test
     public void validateOrderTravelTicketWithUtils() throws InterruptedException {
         ChromeDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

         WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
         oneWayButton.click();

         WebElement passengerBox = driver.findElement(By.xpath("//select[@name='passCount']"));

//         Select passenger = new Select(passengerBox);
//         passenger.selectByValue("4"); //choosing 4 passenger
         BrowserUtils.selectBy(passengerBox,"4", "Value");

         WebElement departingFromBox = driver.findElement(By.xpath("//select[@name='fromPort']"));

         Select departingFrom = new Select(departingFromBox);
         String actualDefault = departingFrom.getFirstSelectedOption().getText();
         String expectedDefault = "Acapulco";
         Assert.assertEquals(actualDefault, expectedDefault);

         //departingFrom.selectByVisibleText("Paris");
         BrowserUtils.selectBy(departingFromBox,"Paris","text");

         WebElement fromMonthBox = driver.findElement(By.xpath("//select[@name='fromMonth']"));

         //Select fromMonth = new Select(fromMonthBox);
         //fromMonth.selectByIndex(7);//August
         BrowserUtils.selectBy(fromMonthBox,"7","index");

         WebElement fromDayBox = driver.findElement(By.xpath("//select[@name='fromDay']"));

         //Select fromDay = new Select(fromDayBox);
         //fromDay.selectByValue("15");
         BrowserUtils.selectBy(fromDayBox,"15","value");

         WebElement toPortBox = driver.findElement(By.xpath("//select[@name='toPort']"));

         //Select toPort = new Select(toPortBox);
         //toPort.selectByValue("San Francisco");
         BrowserUtils.selectBy(toPortBox,"San Francisco","value");

         WebElement toMonthBox = driver.findElement(By.xpath("//select[@name='toMonth']"));

         //Select toMonth = new Select(toMonthBox);
         //toMonth.selectByVisibleText("December");
         BrowserUtils.selectBy(toMonthBox,"December","text");

         WebElement toDayBox = driver.findElement(By.xpath("//select[@name='toDay']"));

         //Select toDay = new Select(toDayBox);
         //toDay.selectByVisibleText("15");
         BrowserUtils.selectBy(toDayBox,"15","text");

         WebElement servicesClasses = driver.findElement(By.xpath("//input[@value='First']"));
         servicesClasses.click();

         WebElement airlinesBox = driver.findElement(By.xpath("//select[@name='airline']"));

         Select airlines = new Select(airlinesBox);

         List<WebElement> allAirlinesOptions = airlines.getOptions();
         List<String> expectedOptions = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines",
                 "Pangea Airlines");

         for (int i = 0; i < allAirlinesOptions.size(); i++) {
             Assert.assertEquals(allAirlinesOptions.get(i).getText(), expectedOptions.get(i));
         }

         airlines.selectByVisibleText("Unified Airlines");

         Thread.sleep(5000);
         WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
         continueButton.click();

         WebElement header = driver.findElement(By.xpath("//font[@size='4']"));
         String actualHeader = header.getText();
         String expectedHeader = "After flight finder - No Seats Available";
         Assert.assertEquals(actualHeader, expectedHeader);
     }
}
