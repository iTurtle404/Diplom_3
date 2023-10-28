package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProfilePage {
    final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    protected static final By profileInfo = By.xpath("//a[text()='Профиль']");
    protected static final By buttonConstructor = By.xpath("//p[text()='Конструктор']");
    protected static final By buttonExit = By.xpath("//button[text()='Выход']");

    //methods
    @Step("Check that go to the Personal Account successfully")
    public ProfilePage checkIntoAccountSuccess() {
        assertTrue(driver.findElements(profileInfo).size() != 0);
        return this;
    }
    @Step("Click on Constructor button ")
    public MainPage clickOnConstructor() {
        driver.findElement(buttonConstructor).click();
        return new MainPage(driver);
    }
    @Step("Click on exit button")
    public LoginPage clickOnExit() {
        driver.findElement(buttonExit).click();
        return new LoginPage(driver);
    }
}
