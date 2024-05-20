package homepage;

import browser_testing.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setupTest(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        driver.findElement(By.xpath("//a[text()='Show AllDesktops']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']")).getText();
        driver.findElement(By.xpath("//a[text()='Show AllComponents']")).getText();
    }

    /*
    1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
        1.1 Mouse hover on “Desktops” Tab and click
        1.2 call selectMenu method and pass the menu = “Show All Desktops”
        1.3 Verify the text ‘Desktops’
     */
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        Actions action = new Actions(driver);
        WebElement desktop = driver.findElement(By.xpath("//a[text()='Desktops']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllDesktops']"));
        action.moveToElement(desktop).moveToElement(click).click().build().perform();

        selectMenu("Show All Desktops");

        String actualText = driver.findElement(By.xpath("//h2[text()='Desktops']")).getText();
        String expectingText = "Desktops";
        Assert.assertEquals("Desktops: ",actualText,expectingText);
    }
    /*
    2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
        2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        2.3 Verify the text ‘Laptops & Notebooks’
     */
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        Actions action = new Actions(driver);
        WebElement laptopAndNotebooks = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        action.moveToElement(laptopAndNotebooks).moveToElement(click).click().build().perform();

        selectMenu("Show All Laptops & Notebooks");

        String actualOutcome = driver.findElement(By.linkText("Laptops & Notebooks")).getText();
        String expectingOutcome = "Laptops & Notebooks";
        Assert.assertEquals("Laptops & Notebooks: ", actualOutcome,expectingOutcome);
    }
    /*
    3. verifyUserShouldNavigateToComponentsPageSuccessfully()
        3.1 Mouse hover on “Components” Tab and click
        3.2 call selectMenu method and pass the menu = “Show All Components”
        3.3 Verify the text ‘Components’
     */
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        Actions action = new Actions(driver);
        WebElement components = driver.findElement(By.xpath("//a[text()='Components']"));
        WebElement click = driver.findElement(By.xpath("//a[text()='Show AllComponents']"));
        action.moveToElement(components).moveToElement(click).click().build().perform();

        selectMenu("Show AllComponents");

        String actualText = driver.findElement(By.xpath("//h2[text()='Components']")).getText();
        String expectingText = "Components";
        Assert.assertEquals("Components: ",actualText,expectingText);
    }

    @After
    public void tearDown(){
        //closeBrowser();
    }






}
