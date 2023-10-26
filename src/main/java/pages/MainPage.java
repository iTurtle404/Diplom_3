package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.TestData.BASE_URL;

public class MainPage {
    final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }
    //locators
    protected static final By buttonEnter = By.xpath("//button[text()='Войти в аккаунт']");

    //methods
    public LoginPage clickOnUpLoginButton() {
        driver.findElement(buttonEnter).click();
        return new LoginPage(driver);
    }
}
