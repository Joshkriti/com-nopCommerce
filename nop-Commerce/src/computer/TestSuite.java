package computer;

import browser_testing.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    public void verifyProductAddedToShoppingCartSuccessFully(){
        //2.1 Click on Computer Menu.
        driver.findElement(By.xpath("//a[text()='Computers ']")).click();

        //2.2 Click on Desktop
        driver.findElement(By.xpath("//div[@class='sub-category-item']/h2/a")).click();

        //2.3 Select Sort By position "Name: A to Z"
        WebElement sortBy = driver.findElement(By.xpath("//*[@id='products-orderby']"));
        Select select = new Select(sortBy);
        select.selectByVisibleText("Name: A to Z");

        //2.4 Click on "Add To Cart"
        driver.findElement(By.className("button-2 product-box-add-to-cart-button")).click();

    }
}
