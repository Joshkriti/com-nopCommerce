package myaccount;

import browser_testing.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountTest extends BaseTest {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountRegister(String option) {
        WebElement dropDown = driver.findElement(By.xpath("//a[@title='My Account']/span[1]"));
        dropDown.click();
        List<WebElement> optionsAccount = driver.findElements(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]/a"));
        for (WebElement options : optionsAccount) {
            if (options.getText().equalsIgnoreCase("Register")) {
                System.out.println(options.getText());
                options.click();
            }
        }
       }
        public void selectMyAccountLogin (String option) {
            WebElement dropDown1 = driver.findElement(By.xpath("//a[@title='My Account']/span[1]"));
            dropDown1.click();
            List<WebElement> optionsAccount1 = driver.findElements(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a"));
            for (WebElement options1 : optionsAccount1) {
                if (options1.getText().equalsIgnoreCase("Login")) {
                    System.out.println(options1.getText());
                    options1.click();
                }
            }
        }
        public  void selectMyAccountLogout(String option){
        WebElement dropdown2 = driver.findElement(By.xpath("//a[@title='My Account']/span[1]"));
        dropdown2.click();
        List <WebElement> logoutOption = driver.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']/li[5]/a"));
        for (WebElement logout: logoutOption){
            if (logout.getText().equalsIgnoreCase("Logout")){
                System.out.println(logout.getText());
                logout.click();
            }
        }
    }
    /*
    1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
        1.1 Click on My Account Link.
        1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
1.      3 Verify the text “Register Account”.
     */
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

        selectMyAccountRegister("Register");

        String actualText = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectingText = "Register Account";
        Assert.assertEquals("Verify register: ",actualText,expectingText);
    }
    /*
    2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
        2.1 Click on My Account Link.
        2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        2.3 Verify the text “Returning Customer”.
     */

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){

        selectMyAccountLogin("Login");

        String actualLoginText = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h2")).getText();
        String expectingLoginText = "Returning Customer";
        Assert.assertEquals("Login: ",actualLoginText,expectingLoginText);


    }
    //3. Test name verifyThatUserRegisterAccountSuccessfully()
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountRegister("Register");

        //3.3 Enter First Name
        driver.findElement(By.name("firstname")).sendKeys("Kriti");

        //3.4 Enter Last Name
        driver.findElement(By.name("lastname")).sendKeys("Josh");

        //3.5 Enter Email
        driver.findElement(By.name("email")).sendKeys("Kritijosh12@gmail.com");

        //3.6 Enter Telephone
        driver.findElement(By.name("telephone")).sendKeys("07715297848");

        //3.7 Enter Password
        driver.findElement(By.name("password")).sendKeys("Kom123456");

        //3.8 Enter Password Confirm
        driver.findElement(By.name("confirm")).sendKeys("Kom123456");

        //3.9 Select Subscribe Yes radio button
        driver.findElement(By.xpath("//*[@class='form-group']/div[1]/label[1]/input")).click();

        //3.10 Click on Privacy Policy check box
        driver.findElement(By.xpath("//*[@name='agree']")).click();

        //3.11 Click on Continue button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        Thread.sleep(2000);

        //3.12 Verify the message “Your Account Has Been Created!”
        String actualVerifyMessage = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        String expectingVerifyMessage = "Your Account Has Been Created!";
        Assert.assertEquals(actualVerifyMessage,expectingVerifyMessage);

        //3.13 Click on Continue button
        driver.findElement(By.xpath("//*[@class='pull-right']/a")).click();

        //3.14 Click on My Account Link.
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountLogout("Logout");

       //3.16 Verify the text “Account Logout”
        String actualLogout = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectingLogout = "Account Logout";
        Assert.assertEquals(actualLogout,expectingLogout);

        Thread.sleep(2000);

       //3.17 Click on Continue button
        driver.findElement(By.xpath("//*[@id='content']/div/div/a")).click();
    }

    //4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountLogin("Login");

        //4.3 Enter Email address
        driver.findElement(By.id("input-email")).sendKeys("Kritijosh12@gmail.com");

        //4.4 Enter Password
        driver.findElement(By.id("input-password")).sendKeys("Kom123456");

        //4.5 Click on Login button
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        Thread.sleep(2000);

        //4.6 Verify text “My Account”
        String actualMyAccount = driver.findElement(By.xpath("//*[@id='content']/h2[1]")).getText();
        String expectingMyAccount = "My Account";
        Assert.assertEquals(actualMyAccount,expectingMyAccount);

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountLogout("Logout");

        //4.10 Verify the text “Account Logout”
        String actualLogout = driver.findElement(By.cssSelector("div[id='content']>h1")).getText();
        String expectingLogout = "Account Logout";
        Assert.assertEquals(actualLogout,expectingLogout);

        //4.11 Click on Continue button
        driver.findElement(By.xpath("//*[@id='content']/div/div/a")).click();
    }
    @After
    public void tearDown(){
       // closeBrowser();
    }

    }

