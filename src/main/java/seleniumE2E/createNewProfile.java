package seleniumE2E;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class createNewProfile {
    public WebDriver driver;
    private String username= "mahmoudshukri.ms";
    private  String accessKey="uvqOFpHOjbNksRv2EZ2yjhue23ICtstR70OeLkHg0L1LsDHP1f";
    private String hub= "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();   // declare information as platforms/ and browser version
    By myAccountMenu = By.xpath("//div[@id='entry_217834']//span[contains(text(),'My account')]");
    By continueButton= By.xpath("//div[@id='content']//a[text()='Continue']");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone= By.id("input-telephone");
    By password= By.id("input-password");
    By confirmPassword= By.id("input-confirm");
    By agreeCheckbox = By.xpath("//label[@for='input-agree']");
    By continueReg = By.xpath("//input[@type='submit' and @value='Continue']");
    By logOut = By.xpath("//div[@id='widget-navbar-217834']//span[contains(text(),'Logout')]");

    @Parameters(value={"Browser", "Version", "Platform"})
    @BeforeMethod
    public void setUp(String browser, String version, String platform) {
        caps.setCapability("build", "1.0");
        caps.setCapability("name", "Selenium E2E");
        caps.setCapability("platform", platform);
        caps.setCapability("version", version);
        caps.setCapability("browserName", browser);
        caps.setCapability("network", true);
        caps.setCapability("console", true);
        caps.setCapability("visual", true);
        caps.setCapability("video", true);

        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" +
                    accessKey + hub), caps);
        } catch(MalformedURLException exc) {
            exc.printStackTrace();
        }
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }


    @Test
    public void test1_createNewProfile() throws InterruptedException {
   // driver.findElement(By.xpath("//div[@id='widget-navbar-217843']//span[contains(text(),'My account')]")).click();click(myAccountMenu);
    click(myAccountMenu);
    click(continueButton);
    type (firstName,"Mahmoud");
    type (lastName,"shukri");
    type (email,generateRandomEmail());
    type (telephone,"01123456987");
    type (password,"3500success");
    type (confirmPassword,"3500success");
    click(agreeCheckbox);
    click(continueReg);
//Hover on my account then click on logout
        Thread.sleep(1000);
    Actions act = new Actions(driver);
    act.moveToElement(find(myAccountMenu)).perform();
        Thread.sleep(1000);
        click(logOut);

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
   private String generateRandomEmail(){
        return RandomStringUtils.random(4,true,true)+ "@gmail.com";
}




}
