package homepage;

import browser_testing.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu){

        driver.findElement(By.linkText(menu)).click();
    }

    @Test
    public void verifyPageNavigation(){

        selectMenu("Computers");
        String actualPageNavigation = "nopCommerce demo store. Computers";
        String expectedPageNavigation = driver.getTitle();
        Assert.assertEquals("computers", actualPageNavigation,expectedPageNavigation);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
