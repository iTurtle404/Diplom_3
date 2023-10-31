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
    protected static final By PROFILE_INFO = By.xpath("//a[text()='Профиль']");
    protected static final By BUTTON_CONSTRUCTOR = By.xpath("//p[text()='Конструктор']");
    protected static final By BUTTON_EXIT = By.xpath("//button[text()='Выход']");

    //methods
    @Step("Check that go to the Personal Account successfully")
    public ProfilePage checkIntoAccountSuccess() {
        assertTrue(driver.findElements(PROFILE_INFO).size() != 0);
        return this;
    }
    @Step("Click on Constructor button ")
    public MainPage clickOnConstructor() {
        driver.findElement(BUTTON_CONSTRUCTOR).click();
        return new MainPage(driver);
    }
    @Step("Click on exit button")
    public LoginPage clickOnExit() {
        driver.findElement(BUTTON_EXIT).click();
        return new LoginPage(driver);
    }
}
