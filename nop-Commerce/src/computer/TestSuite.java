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
import java.util.List;

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
        WebElement selectBy = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
        Select select1 = new Select(selectBy);
        select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        WebElement selectByRAM = driver.findElement(By.xpath("//select[@id='product_attribute_2']"));
        Select select2 = new Select(selectByRAM);
        select2.selectByVisibleText("8GB [+$60.00]");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        WebElement selectHDD = driver.findElement(By.xpath("//dt[@id='product_attribute_label_3']/label[1]"));
        Select select3 = new Select(selectHDD);
        select3.selectByVisibleText("400 GB [+$100.00]");

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        WebElement selectRadio = driver.findElement(By.xpath("//dt[@id='product_attribute_label_4']/label[1]"));
        Select select4 = new Select(selectRadio);
        select4.selectByVisibleText("Vista Premium [+$60.00]");

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        driver.findElement(By.xpath("//*[text()='Microsoft Office [+$50.00]']")).click();
        driver.findElement(By.xpath("//*[text()='Total Commander [+$5.00]']")).click();

        //2.11 Verify the price "$1,475.00"
        String actualPrice = driver.findElement(By.xpath("//*[text()='$1,320.00']")).getText();
        String expectingPrice = "$1,320.00";
        Assert.assertEquals("Total value: $1,320.00" , actualPrice,expectingPrice);

        //2.12 Click on "ADD TO CARD" Button.
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualMessage = driver.findElement(By.xpath("//p[@class='content']")).getText();
        System.out.println(actualMessage);
        String expectingMessage = "The product has been added to your\n" +
                "shopping cart";
        Assert.assertEquals("Print message: ", actualMessage,expectingMessage);

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions action = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.linkText("Shopping cart"));
        WebElement goToCart = driver.findElement(By.xpath("//*[@class='mini-shopping-cart']/div[4]/button[1]"));
        action.moveToElement(shoppingCart).moveToElement(goToCart).build().perform();

        //2.15 Verify the message "Shopping cart"
        String actualShoppingCart = driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        String expectingShoppingCart = "Shopping cart";
        Assert.assertEquals("Shopping cart" , actualShoppingCart ,expectingShoppingCart);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//div[@id='quantity-up-11317']")).click();

        //2.17 Verify the Total"$2,950.00"
        String actualVerifyPrice = driver.findElement(By.linkText("$2,950.00")).getText();
        String expectingVerifyPrice = "$2,950.00";
        Assert.assertEquals("Total price: $2,950.00" , actualVerifyPrice ,expectingVerifyPrice);

        //2.18 click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//div[@class='terms-of-service']/label")).click();

        //2.19 Click on “CHECKOUT”
        driver.findElement(By.xpath("//button[@class='button-1 checkout-button']")).click();

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")).getText();
        String expectingWelcomeText = "Welcome, Please Sign In!";
        Assert.assertEquals("Validating welcome text",expectingWelcomeText,actualWelcomeText);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']")).click();

        //2.22 Fill the all mandatory field
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Kriya");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Josh");
        driver.findElement(By.className("BillingNewAddress.Email")).sendKeys("Kriya.josh@gmail.com");

        WebElement dropDown = driver.findElement(By.id("BillingNewAddress_CountryId"));
        dropDown.click();
        List <WebElement> listOfCountry = driver.findElements(By.xpath("//select[@id='BillingNewAddress_CountryId']/option"));
        for (WebElement country :listOfCountry){
            if (country.getText().equalsIgnoreCase("United Kingtom")){
                System.out.println(country.getText());
                country.click();
            }
        }
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("1 Wembley park");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("HA1 1SF");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9916243569");

        //2.23 Click on “CONTINUE”
        driver.findElement(By.xpath("//button[text()='Continue']")).click();













    }
}
