package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    protected static final By buttonRega = By.className("Auth_link__1fOlj");
    protected static final By buttonEnter =By.xpath("//button[text()='Войти']");


    //methods
    public RegisterPage clickOnRegaButton() {
        driver.findElement(buttonRega).click();
        return new RegisterPage(driver);
    }

    public LoginPage isLoginPage(){
        assertTrue("Registration is fail", driver.findElements(buttonEnter).size() != 0);
        return this;
    }

}
