package testsuite;

import browser_factory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }

    @Test
    /*
    1.userShouldLoginSuccessfullyWithValidCredentials
*       Enter valid username
*       Enter valid password
*       Click on ‘LOGIN’ button
*       Verify the ‘Accounts Overview’ text is display
     */
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        driver.findElement(By.name("username")).sendKeys("Kriti");

        driver.findElement(By.name("password")).sendKeys("Kom123456");

        driver.findElement(By.cssSelector("*[value='Log In']")).click();

        String actualAccount = driver.findElement(By.cssSelector("*[id='showOverview']>h1")).getText();
        String expectingAccount = "Accounts Overview";
        Assert.assertEquals("Account Overview result: ",actualAccount,expectingAccount);

    }
    @Test
    /*
    2.verifyTheErrorMessage
        * Enter invalid username
        * Enter invalid password
        * Click on Login button
        * Verify the error message ‘The username and password could not be verified.’
     */
    public void verifyTheErrorMessage() {

        driver.findElement(By.name("username")).sendKeys("kri11");

        driver.findElement(By.name("password")).sendKeys("Kom34");

        driver.findElement(By.cssSelector("*[value='Log In']")).click();

        String actualErrorMessage = driver.findElement(By.cssSelector("*[class='error']")).getText();
        String expectingErrorMessage = "The username and password could not be verified.";
        Assert.assertEquals("Error Message: ", actualErrorMessage , expectingErrorMessage);
    }

    @Test
    /*
    3.userShouldLogOutSuccessfully
        * Enter valid username
        * Enter valid password
        * Click on ‘LOGIN’ button
        * Click on ‘Log Out’ link
        * Verify the text ‘Customer Login’
     */
    public void userShouldLogOutSuccessfully(){

        driver.findElement(By.name("username")).sendKeys("Kriti");

        driver.findElement(By.name("password")).sendKeys("Kom123456");

        driver.findElement(By.cssSelector("*[value='Log In']")).click();

        driver.findElement(By.xpath("//*[@id='leftPanel']/ul/li[8]/a")).click();

        String actualCustomerLogin = driver.findElement(By.cssSelector("*[id='leftPanel']>h2")).getText();
        String expectingCustomerLogin = "Customer Login";
        Assert.assertEquals("Customer Login: ", actualCustomerLogin, expectingCustomerLogin);





    }
    
}
