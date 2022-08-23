package seleniumE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.annotation.Tainted;

public class AddToCart_Checkout extends BaseTest{

    By myAccountMenu = By.xpath("//div[@id='entry_217834']//span[contains(text(),'My account')]");

    By email = By.id("input-email");

    By password= By.id("input-password");
    By loginButton = By.xpath("//input[@type='submit' and @value='Login']");
    By searchField =By.xpath("//div[@id='entry_217822']//input[@aria-label='Search For Products']");
    By searchButton;
    By iPhone;
    By addToCartButton;

    @Test
    public void test2AddToCart_Checkout(){
        click(myAccountMenu);
        type(email,"Kv0S@gmail.com");
        type(password,"3500success");
        click(loginButton);
        type(searchField,"iphone");
    }

    private WebElement find(By locator){
        return driver.findElement(locator);
    }
    private void click (By locator){
        find(locator).click();
    }
    private void type(By locator, String text){
        find(locator).sendKeys(text);
    }
}
