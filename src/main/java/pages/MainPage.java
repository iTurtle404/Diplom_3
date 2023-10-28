package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
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
    protected static final By buttonPersAcc = By.xpath("//p[text()='Личный Кабинет']");
    protected static final By constructorInfo = By.xpath("//h1[text()='Соберите бургер']");

    //methods
    public LoginPage clickOnUpLoginButton() {
        driver.findElement(buttonEnter).click();
        return new LoginPage(driver);
    }
    public ProfilePage clickOnPersAccButton() {
        driver.findElement(buttonPersAcc).click();
        return new ProfilePage(driver);
    }
    public MainPage checkIsMainPage() {
        assertTrue(driver.findElements(constructorInfo).size() != 0);
        return this;
    }
}
