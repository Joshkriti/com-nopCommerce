package testsuite;

import browser_factory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }

    @Test
    /*
    1.verifyThatSigningUpPageDisplay
        * click on the ‘Register’ link
        * Verify the text ‘Signing up is easy!’
     */
    public void verifyThatSigningUpPageDisplay(){

        driver.findElement(By.xpath("//a[text()='Register']")).click();

        String actualSignUp = driver.findElement(By.className("title")).getText();
        String expectingSignUp = "Signing up is easy!";
        Assert.assertEquals("Signing up is easy: ",actualSignUp, expectingSignUp);
    }
    @Test
    /*2.userShouldRegisterAccountSuccessfully
     * click on the ‘Register’ link  * Enter First name * Enter Last name
     * Enter Address * Enter City * Enter State * Enter Zip Code
     * Enter Phone * Enter SSN * Enter Username * Enter Password
     * Enter Confirm * Click on REGISTER button
     * Verify the text 'Your account was created successfully. You are now logged in.’
     */
    public void userShouldRegisterAccountSuccessfully(){

    driver.findElement(By.xpath("//a[text()='Register']")).click();

    driver.findElement(By.id("customer.firstName")).sendKeys("Kriti");

    driver.findElement(By.id("customer.lastName")).sendKeys("Josh");

    driver.findElement(By.id("customer.address.street")).sendKeys("1 Bristol Street");

    driver.findElement(By.id("customer.address.city")).sendKeys("Bristol");

    driver.findElement(By.id("customer.address.state")).sendKeys("SouthWest");

    driver.findElement(By.id("customer.address.zipCode")).sendKeys("NH10 1HJ");

    driver.findElement(By.id("customer.phoneNumber")).sendKeys("9426698352");

    driver.findElement(By.id("customer.ssn")).sendKeys("252624298");

    driver.findElement(By.id("customer.username")).sendKeys("Kriti");

    driver.findElement(By.id("customer.password")).sendKeys("Kri123456");

    driver.findElement(By.id("repeatedPassword")).sendKeys("Kri123456");

    driver.findElement(By.xpath("//input[@value='Register']")).click();

    String actualOutcome = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")).getText();
    String expectingOutcome = "Your account was created successfully. You are now logged in.";
    Assert.assertEquals(actualOutcome,expectingOutcome);


    }


}
