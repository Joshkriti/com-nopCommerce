package desktops;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DesktopsTest extends TopMenuTest {

    String baseUrl = "https://tutorialsninja.com/demo/index.php?route=common/home";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    /*
    1.Test name verifyProductArrangeInAlphaBaticalOrder()
        1.1 Mouse hover on Desktops Tab.and click
        1.2 Click on “Show All Desktops”
        1.3 Select Sort By position "Name: Z to A"
        1.4 Verify the Product will arrange in Descending order.
     */
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        Actions action = new Actions(driver);
        WebElement desktop = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        action.moveToElement(desktop).moveToElement(click).click().build().perform();


        WebElement dropDown = driver.findElement(By.cssSelector("*[id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");
    }

    /*
    2. Test name verifyProductAddedToShoppingCartSuccessFully()
        2.1 Mouse hover on Desktops Tab. and click --> 2.2 Click on “Show All Desktops”
        2.3 Select Sort By position "Name: A to Z" --> 2.4 Select product “HP LP3065”
        2.5 Verify the Text "HP LP3065" --> 2.6 Select Delivery Date "2022-11-30"
        2.7.Enter Qty "1” using Select class. --> 2.8 Click on “Add to Cart” button
        2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        2.10 Click on link “shopping cart” display into success message
        2.11 Verify the text "Shopping Cart" --> 2.12 Verify the Product name "HP LP3065"
        2.13 Verify the Delivery Date "2022-11-30" --> 2.14 Verify the Model "Product21"
        2.15 Verify the Todat "£74.73"
     */
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {

        Actions action = new Actions(driver);
        WebElement desktop = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        action.moveToElement(desktop).moveToElement(click).click().build().perform();

        selectMenu("Show All Desktops");

        WebElement dropDown = driver.findElement(By.xpath("//*[@id='input-sort']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[text()='HP LP3065']")).click();

        driver.findElement(By.name("option[225]")).clear();

        driver.findElement(By.name("option[225]")).sendKeys("2022-11-30");

        driver.findElement(By.cssSelector("*[id='input-quantity']")).clear();

        driver.findElement(By.cssSelector("*[id='input-quantity']")).sendKeys("1");

        driver.findElement(By.cssSelector("*[id='button-cart']")).click();

        String actualMessage = driver.findElement(By.cssSelector("*[class='alert alert-success alert-dismissible']")).getText();
        System.out.println(actualMessage);
        String expectingMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        Assert.assertEquals("Message to add into card successfully ", actualMessage, expectingMessage);

        driver.findElement(By.xpath("//a[text()='shopping cart']")).click();

        String actualShoppingCart = driver.findElement(By.xpath("//div[@id='content']/h1[1]")).getText();
        String expectingShoppingCart = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(actualShoppingCart, expectingShoppingCart);

        String actualProductName = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/a")).getText();
        String expectingProductName = "HP LP3065";
        Assert.assertEquals("Product Name: ", actualProductName, expectingProductName);

        String actualDeliveryDate = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[2]/small")).getText();
        String expectingDeliveryDate = "Delivery Date:2022-11-30";
        Assert.assertEquals("Delivery Date: ", actualDeliveryDate, expectingDeliveryDate);

        String actualModel = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[3]")).getText();
        String expectingModel = "Product 21";
        Assert.assertEquals("Model name: ", actualModel, expectingModel);

        String actualTotal = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[6]")).getText();
        String expectingTotal = "$122.00";
        Assert.assertEquals("Total cost: ", actualTotal, expectingTotal);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}

