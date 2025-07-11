package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PracticeIframe {
    public static void main(String[] args) {
        /*
IFRAME PRACTICE HOMEWORK
1. go to https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box
2. retrieve and print "New Browser Tab" text
3. click on "Open Seprate New Window"
4. retrieve and print "Open New Seprate Window" text
5. click on "Open Frameset Window"
6. retrieve and print "Open Frameset Window" text
7. click on "Multiple Windows"
8. retrieve and print "Open Frameset Window" text
9. Open multiple pages
 */
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult1.html']"));
        driver.switchTo().frame(iframe1);
        WebElement text1 = driver.findElement(By.xpath("//a[.='New Browser Tab']"));
        System.out.println(text1.getText());
        driver.switchTo().parentFrame();

        WebElement button1 = driver.findElement(By.xpath("//a[contains(text(), 'Seprate New' )]"));
        button1.click();

        WebElement iframe2 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult2.html']"));
        driver.switchTo().frame(iframe2);
        WebElement text2 = driver.findElement(By.xpath("//a[.='Open New Seprate Window']"));
        System.out.println(text2.getText());
        driver.switchTo().parentFrame();

        WebElement button2 = driver.findElement(By.xpath("//a[contains(text(), 'Frameset' )]"));
        button2.click();
        WebElement iframe3 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult3.html']"));
        driver.switchTo().frame(iframe3);
        WebElement text3= driver.findElement(By.xpath("//a[.='Open Frameset Window']"));
        System.out.println(text3.getText());
        driver.switchTo().parentFrame();

        WebElement button3 = driver.findElement(By.xpath("//a[contains(text(), 'Open Multiple Windows' )]"));
        button3.click();
        WebElement iframe4 = driver.findElement(By.xpath("//iframe[@src='frames-windows/defult4.html']"));
        driver.switchTo().frame(iframe4);
        WebElement text4= driver.findElement(By.xpath("//a[.='Open multiple pages']"));
        System.out.println(text4.getText());
        text4.click();
        driver.switchTo().defaultContent();



    }
}
