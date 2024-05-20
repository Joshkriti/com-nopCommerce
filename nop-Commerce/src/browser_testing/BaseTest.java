package browser_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {


    public static WebDriver driver;
    public void openBrowser(String baseUrl){

        driver = new ChromeDriver();

        driver.get(baseUrl);

        String title = driver.getTitle();
        System.out.println(title);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    public void closeBrowser(){
        driver.quit();
    }

}
