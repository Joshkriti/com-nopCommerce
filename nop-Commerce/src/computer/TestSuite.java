package computer;

import browser_testing.BaseTest;
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

public class TestSuite extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    @Test
    /*
    1.Test name verifyProductArrangeInAlphaBaticalOrder()
        1.1 Click on Computer Menu.
        1.2 Click on Desktop
        1.3 Select Sort By position "Name: Z to A"
        1.4 Verify the Product will arrange in Descending order.
     */
    public void verifyProductArrangeInAlphaBaticalOrder(){

        WebElement clickOnComputer = driver.findElement(By.xpath("//a[text()='Computers ']"));
        clickOnComputer.click();

        WebElement clickOnDesktop = driver.findElement(By.xpath("//div[@class='sub-category-item']/h2/a"));
        clickOnDesktop.click();

        WebElement sortBy = driver.findElement(By.xpath("//*[@id='products-orderby']"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Name: Z to A");
    }

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        driver.findElement(By.xpath("//a[text()='Computers ']")).click();

        //2.2 Click on Desktop
        driver.findElement(By.xpath("//div[@class='sub-category-item']/h2/a")).click();

        //2.3 Select Sort By position "Name: A to Z"
        WebElement sortBy = driver.findElement(By.xpath("//*[@id='products-orderby']"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Name: A to Z");

        //2.4 Click on "Add To Cart"
       WebElement button= driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(button));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();


        //2.5 Verify the Text "Build your own computer"
        String actualText = driver.findElement(By.xpath("//h1[text()='Build your own computer']")).getText();
        String expectingText = "Build your own computer";
        Assert.assertEquals("Build your own computer", actualText ,expectingText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement selectBy = driver.findElement(By.id("product_attribute_1"));
        Select select1 = new Select(selectBy);
        select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        WebElement selectByRAM = driver.findElement(By.name("product_attribute_2"));
        Select select2 = new Select(selectByRAM);
        select2.selectByVisibleText("8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//*[@for='product_attribute_3_7']")).click();

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//*[@for='product_attribute_4_9']")).click();

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"

        driver.findElement(By.xpath("//*[@id='product_attribute_input_5']/ul/li[3]/label")).click();


        //2.11 Verify the price "$1,475.00"
        String actualPrice = driver.findElement(By.cssSelector("*[class='prices']>div>span")).getText();
        String expectingPrice = "$1,315.00";
        Assert.assertEquals(actualPrice,expectingPrice);

        //2.12 Click on "ADD TO CARD" Button.
        driver.findElement(By.xpath("//*[@class='button-1 add-to-cart-button']")).click();

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualMessage = driver.findElement(By.xpath("//p[@class='content']")).getText();
        System.out.println(actualMessage);
        String expectingMessage = "The product has been added to your shopping cart";
        Assert.assertEquals("Print message: ", actualMessage,expectingMessage);

        driver.findElement(By.xpath("//*[@class='close']")).click();

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions action = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.cssSelector("*[class='cart-label']"));
        WebElement goToCart = driver.findElement(By.xpath("//*[@id='flyout-cart']/div/div[4]/button"));
        Thread.sleep(2000);
        action.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();

        //2.15 Verify the message "Shopping cart"
        String actualShoppingCart = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        String expectingShoppingCart = "Shopping cart";
        Assert.assertEquals("Shopping cart" , actualShoppingCart ,expectingShoppingCart);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"

        driver.findElement(By.cssSelector("*[class='quantity up']")).click();


        //2.17 Verify the Total"$2,950.00"
        String actualVerifyPrice = driver.findElement(By.xpath("//*[@class='product-subtotal']")).getText();
        String expectingVerifyPrice = "$2,950.00";
        Assert.assertEquals("Total price: $2,950.00" , actualVerifyPrice ,expectingVerifyPrice);

        //2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//div[@class='terms-of-service']/label")).click();

        Thread.sleep(2000);

        //2.19 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@class='button-1 checkout-button']")).click();

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
        String expectingWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals("Validating welcome text",expectingWelcomeText,actualWelcomeText);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']")).click();

        Thread.sleep(2000);

        //2.22 Fill the all mandatory field
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Kriya");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Josh");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Kriya.josh@gmail.com");

        WebElement selectBy1 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select3 = new Select(selectBy1);
        select3.selectByVisibleText("United Kingdom");

        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("1 Wembley park");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("HA1 1SF");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9916243569");

        Thread.sleep(2000);

        //2.23 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[text()='Continue']")).click();


        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        driver.findElement(By.id("shippingoption_1")).click();

        // 2.25 Click on “CONTINUE”
        driver.findElement(By.xpath("//*[@class='button-1 shipping-method-next-step-button']")).click();

        //2.26 Select Radio Button “Credit Card”
        driver.findElement(By.id("paymentmethod_1")).click();

        driver.findElement(By.xpath("//*[@id='payment-method-buttons-container']/button")).click();

        //2.27 Select “Master card” From Select credit card dropdown
        WebElement sortBy2 = driver.findElement(By.id("CreditCardType"));
        Select select4 = new Select(sortBy2);
        select4.selectByVisibleText("Master card");

        //2.28 Fill all the details
        driver.findElement(By.name("CardholderName")).sendKeys("K Josh");
        driver.findElement(By.id("CardNumber")).sendKeys("5555 5555 5555 4444");

        WebElement sortMonth = driver.findElement(By.id("ExpireMonth"));
        Select selectMonth = new Select(sortMonth);
        selectMonth.selectByVisibleText("12");

        WebElement sortYear = driver.findElement(By.id("ExpireYear"));
        Select selectYear = new Select(sortYear);
        selectYear.selectByVisibleText("2026");

        driver.findElement(By.id("CardCode")).sendKeys("123");

        Thread.sleep(2000);

        //2.29 Click on “CONTINUE”
        driver.findElement(By.xpath("//*[@id='payment-info-buttons-container']/button")).click();

        //2.30 Verify “Payment Method” is “Credit Card”
        String actualPaymentMethod = driver.findElement(By.xpath("//*[@class='payment-method']/span[2]")).getText();
        String expectingPaymentMethod = "Credit Card";
        Assert.assertEquals(actualPaymentMethod, expectingPaymentMethod);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String actualShippingMethod = driver.findElement(By.xpath("//*[@class='shipping-method']/span[2]")).getText();
        String expectingShippingMethod = "Next Day Air";
        Assert.assertEquals(actualShippingMethod, expectingShippingMethod);

        //2.33 Verify Total is “$2,950.00”
        String actualVerifyTotal = driver.findElement(By.xpath("//*[@class='value-summary']/strong")).getText();
        String expectingVerifyTotal= "$2,950.00";
        Assert.assertEquals(actualVerifyTotal,expectingVerifyTotal);

        Thread.sleep(2000);

        //2.34 Click on “CONFIRM”
         driver.findElement(By.xpath("//*[@id='confirm-order-buttons-container']/button")).click();

        //2.35 Verify the Text “Thank You”
        String actualVerifyText = driver.findElement(By.xpath("//*[@class='page checkout-page order-completed-page']/div[1]/h1")).getText();
        String expectingVerifyText= "Thank you";
        Assert.assertEquals(actualVerifyText,expectingVerifyText);

        //2.36 Verify the message “Your order has been successfully processed!”
        String actualVerifyMessage = driver.findElement(By.xpath("//*[@class='section order-completed']/div[1]/strong")).getText();
        String expectingVerifyMessage= "Your order has been successfully processed!";
        Assert.assertEquals(actualVerifyMessage,expectingVerifyMessage);

        Thread.sleep(2000);

        //2.37 Click on “CONTINUE”
        driver.findElement(By.xpath("//*[@class='section order-completed']/div[3]/button")).click();

        //2.37 Verify the text “Welcome to our store”
        String actualVerifyText1 = driver.findElement(By.xpath("//*[@class='topic-block']/div[1]/h2")).getText();
        String expectingVerifyText1= "Welcome to our store";
        Assert.assertEquals(actualVerifyText1,expectingVerifyText1);













    }
}
