package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPage {
    final WebDriver driver;
    public ForgotPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static final By enterByForgot = By.xpath("//a[text()='Войти']");

    public LoginPage clickOnEnterButton() {
        driver.findElement(enterByForgot).click();
        return new LoginPage(driver);
    }

}
