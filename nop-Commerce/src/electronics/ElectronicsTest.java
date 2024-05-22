package electronics;

import browser_testing.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElectronicsTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }
    /*
    1. Create the class ElectronicsTest write the following test
        1.0 Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
        1.1 Mouse Hover on “Electronics” Tab
        1.2 Mouse Hover on “Cell phones” and click
        1.3 Verify the text “Cell phones”
     */
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        Actions action = new Actions(driver);
        WebElement electronic = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        WebElement cellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul[1]/li[2]/a"));
        action.moveToElement(electronic).moveToElement(cellPhones).click().build().perform();

        String actualVerifyText = driver.findElement(By.xpath("//*[@class='page-title']/h1")).getText();
        String expectingVerifyText = "Cell phones";
        Assert.assertEquals("Cell phones: ", actualVerifyText,expectingVerifyText);
    }
    @Test
    /*
    2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
        2.1 Mouse Hover on “Electronics” Tab
        2.2 Mouse Hover on “Cell phones” and click
        2.3 Verify the text “Cell phones” */

    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement electronic = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"));
        WebElement cellPhones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul[1]/li[2]/a"));
        action.moveToElement(electronic).moveToElement(cellPhones).click().build().perform();

        String actualVerifyText = driver.findElement(By.xpath("//*[@class='page-title']/h1")).getText();
        String expectingVerifyText = "Cell phones";
        Assert.assertEquals("Cell phones: ", actualVerifyText,expectingVerifyText);

        //2.4 Click on List View Tab
        driver.findElement(By.xpath("//div[@class='product-viewmode']/a[2]")).click();

        //2.5 Click on product name “Nokia Lumia 1020” link
        WebElement button= driver.findElement(By.xpath("//*[text()='Nokia Lumia 1020']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Nokia Lumia 1020']")).click();

        //2.6 Verify the text “Nokia Lumia 1020”
        String actualText = driver.findElement(By.cssSelector("div[class='overview']>div>h1")).getText();
        String expectingText = "Nokia Lumia 1020";
        Assert.assertEquals("Verify text: " , actualText,expectingText);

        //2.7 Verify the price “$349.00”
        String actualPrice = driver.findElement(By.cssSelector("div[class='prices']>div>span")).getText();
        String expectingPrice = "$349.00";
        Assert.assertEquals("price of product: ",actualPrice,expectingPrice);

        driver.findElement(By.id("product_enteredQuantity_20")).clear();

        //2.8 Change quantity to 2
        driver.findElement(By.id("product_enteredQuantity_20")).sendKeys("2");

        //2.9 Click on “ADD TO CART” tab
        driver.findElement(By.cssSelector("div[class='add-to-cart-panel']>button")).click();

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualMessage = driver.findElement(By.cssSelector("div[class='bar-notification success']>p")).getText();
        String expectingMessage = "The product has been added to your shopping cart";
        Assert.assertEquals("Verify message: ",actualMessage,expectingMessage);

        //After that close the bar clicking on the cross button.
        driver.findElement(By.cssSelector("span[class='close']")).click();

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions action1 = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.cssSelector("*[class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//*[@id='flyout-cart']/div/div[4]/button"));
        Thread.sleep(2000);
        action.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

        //2.12 Verify the message "Shopping cart"
        String actualShoppingCart = driver.findElement(By.cssSelector("div[class='page shopping-cart-page']>div>h1")).getText();
        String expectingShoppingCart = "Shopping cart";
        Assert.assertEquals("Shopping cart: ", actualShoppingCart,expectingShoppingCart);

        //2.13 Verify the quantity is 2
        String actualQuantity = driver.findElement(By.cssSelector("div[class='product-quantity']>input")).getText();
        String expectingQuantity = "";
        Assert.assertEquals("Verify quantity: ",actualQuantity,expectingQuantity);

        //2.14 Verify the Total $698.00
        String actualTotal = driver.findElement(By.cssSelector("td[class='cart-total-right']>span>strong")).getText();
        String expectingTotal = "$698.00";
        Assert.assertEquals("Total cost: ", actualTotal,expectingTotal);

        //2.15 click on checkbox “I agree with the terms of service”
        driver.findElement(By.cssSelector("div[class='terms-of-service']>label")).click();

        //2.16 Click on “CHECKOUT”
        driver.findElement(By.cssSelector("div[class='checkout-buttons']>button")).click();

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
        String expectingWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals("Validating welcome text",expectingWelcomeText,actualWelcomeText);

        //2.18 Click on “REGISTER” tab
        driver.findElement(By.xpath("//button[@class='button-1 register-button']")).click();

        //2.19 Verify the text “Register”
        String actualRegister = driver.findElement(By.cssSelector("div[class='page registration-page']>div>h1")).getText();
        String expectingRegister = "Register";
        Assert.assertEquals("Register page: " , actualRegister,expectingRegister);

        //2.20 Fill the mandatory fields
        driver.findElement(By.className("female")).click();

        driver.findElement(By.id("FirstName")).sendKeys("Komal");

        driver.findElement(By.name("LastName")).sendKeys("Kanji");

        WebElement sortBirthDay = driver.findElement(By.name("DateOfBirthDay"));
        Select selectBirthDay = new Select(sortBirthDay);
        selectBirthDay.selectByVisibleText("13");

        WebElement sortMonth = driver.findElement(By.name("DateOfBirthMonth"));
        Select selectMonth = new Select(sortMonth);
        selectMonth.selectByVisibleText("September");

        WebElement sortYear = driver.findElement(By.name("DateOfBirthYear"));
        Select selectYear= new Select(sortYear);
        selectYear.selectByVisibleText("1998");

        driver.findElement(By.id("Email")).sendKeys("Komalkanji21@gmail.com");

        Thread.sleep(2000);

        driver.findElement(By.id("Password")).sendKeys("Kom123456");

        driver.findElement(By.name("ConfirmPassword")).sendKeys("Kom123456");

        //2.21 Click on “REGISTER” Button
        driver.findElement(By.id("register-button")).click();

        //2.22 Verify the message “Your registration completed”
        String actualRegisterSuccessful = driver.findElement(By.xpath("//div[@class='page-body']/div[1]")).getText();
        String expectingRegisterSuccessful = "Your registration completed";
        Assert.assertEquals("Register completed ",actualRegisterSuccessful,expectingRegisterSuccessful);

        //2.23 Click on “CONTINUE” tab
        driver.findElement(By.xpath("//*[@class='page-body']/div[2]/a")).click();

        //2.24 Verify the text “Shopping card”
        String actualShoppingCart1 = driver.findElement(By.cssSelector("div[class='page shopping-cart-page']>div>h1")).getText();
        String expectingShoppingCart1 = "Shopping cart";
        Assert.assertEquals("Shopping cart: ", actualShoppingCart1,expectingShoppingCart1);

        //2.25 click on checkbox “I agree with the terms of service”
        driver.findElement(By.cssSelector("div[class='terms-of-service']>label")).click();

        //2.26 Click on “CHECKOUT”
        driver.findElement(By.cssSelector("div[class='checkout-buttons']>button")).click();

        //2.27 Fill the Mandatory fields
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("");

        WebElement selectBy1 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select3 = new Select(selectBy1);
        select3.selectByVisibleText("United Kingdom");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("1 Wembley park");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("HA1 1SF");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9916243569");

        Thread.sleep(2000);

        //2.28 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[text()='Continue']")).click();

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        driver.findElement(By.id("shippingoption_1")).click();

        //2.30 Click on “CONTINUE”
        driver.findElement(By.xpath("//*[@class='button-1 shipping-method-next-step-button']")).click();

        //2.31 Select Radio Button “Credit Card”
        driver.findElement(By.id("paymentmethod_1")).click();

        driver.findElement(By.xpath("//*[@id='payment-method-buttons-container']/button")).click();


        //2.32 Select “Visa” From Select credit card dropdown
        WebElement sortCreditCard = driver.findElement(By.id("CreditCardType"));
        Select select4 = new Select(sortCreditCard);
        select4.selectByVisibleText("Visa");

        //2.33 Fill all the details
        driver.findElement(By.name("CardholderName")).sendKeys("K Josh");
        driver.findElement(By.id("CardNumber")).sendKeys("4242 4242 4242 4242");

        WebElement sortExpireMonth = driver.findElement(By.id("ExpireMonth"));
        Select selectExpireMonth = new Select(sortExpireMonth);
        selectExpireMonth.selectByVisibleText("06");

        WebElement sortExpireYear = driver.findElement(By.id("ExpireYear"));
        Select selectExpireYear = new Select(sortExpireYear);
        selectExpireYear.selectByVisibleText("2025");

        driver.findElement(By.id("CardCode")).sendKeys("321");

        Thread.sleep(2000);

        //2.34 Click on “CONTINUE”
        driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/button")).click();

        //2.35 Verify “Payment Method” is “Credit Card”
        String actualPaymentMethod = driver.findElement(By.xpath("//*[@class='payment-method']/span[2]")).getText();
        String expectingPaymentMethod = "Credit Card";
        Assert.assertEquals(actualPaymentMethod, expectingPaymentMethod);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String actualShippingMethod = driver.findElement(By.xpath("//*[@class='shipping-method']/span[2]")).getText();
        String expectingShippingMethod = "Next Day Air";
        Assert.assertEquals(actualShippingMethod, expectingShippingMethod);

        //2.37 Verify Total is “$698.00”
        String actualVerifyTotal = driver.findElement(By.cssSelector("span[class='value-summary']>strong")).getText();
        String expectingVerifyTotal= "$698.00";
        Assert.assertEquals(actualVerifyTotal,expectingVerifyTotal);

        Thread.sleep(2000);

        //2.38 Click on “CONFIRM”
        driver.findElement(By.xpath("//*[@id='confirm-order-buttons-container']/button")).click();

        //2.39 Verify the Text “Thank You”
        String actualVerifyText1 = driver.findElement(By.xpath("//*[@class='page checkout-page order-completed-page']/div[1]/h1")).getText();
        String expectingVerifyText1= "Thank you";
        Assert.assertEquals(actualVerifyText1,expectingVerifyText1);

        //2.40 Verify the message “Your order has been successfully processed!”
        String actualVerifyMessage = driver.findElement(By.xpath("//*[@class='section order-completed']/div[1]/strong")).getText();
        String expectingVerifyMessage= "Your order has been successfully processed!";
        Assert.assertEquals(actualVerifyMessage,expectingVerifyMessage);

        Thread.sleep(2000);

        //2.41 Click on “CONTINUE”
        driver.findElement(By.xpath("//*[@class='section order-completed']/div[3]/button")).click();

        //2.42 Verify the text “Welcome to our store”
        String actualVerifyText2 = driver.findElement(By.xpath("//*[@class='topic-block']/div[1]/h2")).getText();
        String expectingVerifyText2= "Welcome to our store";
        Assert.assertEquals(actualVerifyText2,expectingVerifyText2);

        //2.43 Click on “Logout” link
        driver.findElement(By.cssSelector("a[class='ico-logout']")).click();

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://demo.nopcommerce.com/" );
    }
    @After
    public void tearDown(){
        //closeBrowser();
    }


}
