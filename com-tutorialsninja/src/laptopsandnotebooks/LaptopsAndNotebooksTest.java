package laptopsandnotebooks;

import homepage.TopMenuTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LaptopsAndNotebooksTest extends TopMenuTest {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    /*
    1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
        1.1 Mouse hover on Laptops & Notebooks Tab.and click
        1.2 Click on “Show All Laptops & Notebooks”
        1.3 Select Sort By "Price (High > Low)"
        1.4 Verify the Product price will arrange in High to Low order.
     */
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){

        Actions action = new Actions(driver);
        WebElement laptopAndNotebooks = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        action.moveToElement(laptopAndNotebooks).moveToElement(click).click().build().perform();

        WebElement dropDown = driver.findElement(By.xpath("//*[@class='form-control']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");

        String actualProductPrice = driver.findElement(By.xpath("//*[@class='form-group input-group input-group-sm']/select/option[5]")).getText();
        String expectingProductPrice = "Price (High > Low)";
        Assert.assertEquals("Verify price: " , actualProductPrice,expectingProductPrice);
    }
    /*
    2. Test name verifyThatUserPlaceOrderSuccessfully()
        2.1 Mouse hover on Laptops & Notebooks Tab and click
        2.2 Click on “Show All Laptops & Notebooks”
        2.3 Select Sort By "Price (High > Low)"
        2.4 Select Product “MacBook”
        2.5 Verify the text “MacBook”
        2.6 Click on ‘Add To Cart’ button
        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        2.8 Click on link “shopping cart” display into success message
        2.9 Verify the text "Shopping Cart"
        2.10 Verify the Product name "MacBook"
        2.11 Change Quantity "2"
        2.12 Click on “Update” Tab
        2.13 Verify the message “Success: You have modified your shopping cart!”
        2.14 Verify the Total £737.45
        2.15 Click on “Checkout” button
        2.16 Verify the text “Checkout”
        2.17 Verify the Text “New Customer”
        2.18 Click on “Guest Checkout” radio button
        2.19 Click on “Continue” tab
        2.20 Fill the mandatory fields
        2.21 Click on “Continue” Button
        2.22 Add Comments About your order into text area
        2.23 Check the Terms & Conditions check box
        2.24 Click on “Continue” button
        2.25 Verify the message “Warning: Payment method required!”
     */
    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){

        Actions action = new Actions(driver);
        WebElement laptopAndNotebooks = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        action.moveToElement(laptopAndNotebooks).moveToElement(click).click().build().perform();

        WebElement dropDown = driver.findElement(By.xpath("//*[@class='form-control']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (High > Low)");






}














    @After
    public void tearDown(){
        //closeBrowser();
    }
}
