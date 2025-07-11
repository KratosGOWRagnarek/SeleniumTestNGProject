package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToSelenium {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        // actual comes from website
//        String actualTitle= driver.getTitle();// to make sure we are on a correct page
//        String expectedTitle = "Amazon.com. Spend less. Smile more."; // it comes from you (story)
//        if ( actualTitle.equals(expectedTitle)) {
//            System.out.println("title is passed");
//        } else {
//            System.out.println("title is failed");
//        }
        driver.manage().window().maximize();//make my screen maximize
        driver.get("https://www.facebook.com/");
        String actualtitleFacebook = driver.getTitle();
        String Facebookexpectedtitle = "Facebook - log in or sign up";
        if ( actualtitleFacebook.equals(Facebookexpectedtitle)) {
            System.out.println("title is passed");
        } else {
            System.out.println("title is failed");
        }

        String actualFacebookURl = driver.getCurrentUrl();// to make sure you are on correct page
        String expectedFacebookUrl = "https://www.facebook.com/";
        System.out.println(actualFacebookURl.equals(expectedFacebookUrl) ? "URl passed" : "URL failed");



        driver.close(); // it closes the browser

    }
}
