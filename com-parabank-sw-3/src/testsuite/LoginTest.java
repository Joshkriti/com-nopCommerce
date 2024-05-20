package testsuite;

import browser_factory.BaseTest;
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

        driver.findElement(By.name("username")).sendKeys("kriya");

        driver.findElement(By.name("password")).sendKeys("Kom123456");

        driver.findElement(By.cssSelector("*[value='Log In']")).click();

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

        driver.findElement(By.name("username")).sendKeys("kriya11");

        driver.findElement(By.name("password")).sendKeys("Kom1234");

        driver.findElement(By.cssSelector("*[value='Log In']")).click();

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

        driver.findElement(By.name("username")).sendKeys("kriya1");

        driver.findElement(By.name("password")).sendKeys("Kom123456");

        driver.findElement(By.cssSelector("*[value='Log In']")).click();

        driver.findElement(By.linkText("Log Out")).click();

    }
    
}
