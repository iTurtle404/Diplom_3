package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPage {
    final WebDriver driver;
    public ForgotPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    protected static final By enterByForgot = By.xpath("//a[text()='Войти']");

    //methods
    @Step("Click on Enter button")
    public LoginPage clickOnEnterButton() {
        driver.findElement(enterByForgot).click();
        return new LoginPage(driver);
    }

}
