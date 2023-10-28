package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProfilePage {
    final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    protected static final By profileInfo = By.xpath("//a[text()='Профиль']");

    protected static final By buttonConstructor = By.xpath("//p[text()='Конструктор']");
    protected static final By buttonExit = By.xpath("//button[text()='Выход']");

    public ProfilePage checkIntoAccountSuccess() {
        assertTrue(driver.findElements(profileInfo).size() != 0);
        return this;
    }
    public MainPage clickOnConstructor() {
        driver.findElement(buttonConstructor).click();
        return new MainPage(driver);
    }
    public LoginPage clickOnExit() {
        driver.findElement(buttonExit).click();
        return new LoginPage(driver);
    }
}
