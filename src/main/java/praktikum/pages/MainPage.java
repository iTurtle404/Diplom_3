package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.EnvConfig.BASE_URL;
import static praktikum.constants.Message.*;

public class MainPage {
    final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }
    public static final String ARG_FOR_SCROLL = "arguments[0].scrollIntoView();";

    //locators
    protected static final By BUTTON_LOG_IN = By.xpath("//button[text()='Войти в аккаунт']");
    protected static final By BUTTON_PERS_ACC = By.xpath("//p[text()='Личный Кабинет']");
    protected static final By CONSTRUCTOR_INFO = By.xpath("//h1[text()='Соберите бургер']");
    protected static final By BUTTON_SAUCE = By.xpath("//span[text()='Соусы']");
    protected static final By BUTTON_FILLING = By.xpath("//span[text()='Начинки']");
    protected static final By BUTTON_BUN = By.xpath("//span[text()='Булки']");
    protected static final By BUN= By.xpath("//h2[text()='Булки']");
    protected static final By SAUCE = By.xpath("//h2[text()='Начинки']");
    protected static final By FILING = By.xpath("//h2[text()='Соусы']");

    protected static final By SECTION = By.cssSelector(".tab_tab_type_current__2BEPc");

    //methods
    @Step("Click on Login button")
    public LoginPage clickOnLoginButton() {
        driver.findElement(BUTTON_LOG_IN).click();
        return new LoginPage(driver);
    }
    //если пользователь еще не авторизован - клик перекидывает на страницу регистрации
    @Step("Click on Personal Account button with unauthorized user")
    public LoginPage  clickOnPersAccButtonForLogin() {
        driver.findElement(BUTTON_PERS_ACC).click();
        return new LoginPage (driver);
    }
    //если пользователь уже авторизован - клик перекидывает на страницу профиля
    @Step("Click on Personal Account button for go to Profile. authorized user")
    public ProfilePage clickOnPersAccButtonForProfile() {
        driver.findElement(BUTTON_PERS_ACC).click();
        return new ProfilePage (driver);
    }
    @Step("Check that is Main Page")
    public MainPage checkIsMainPage() {
        assertTrue(driver.findElements(CONSTRUCTOR_INFO).size() != 0);
        return this;
    }
    @Step("Get text by visible section")
    private String getTextBySection() {
        return driver.findElement((SECTION)).getText();
    }

    @Step("Click on Sauce section")
    public MainPage clickOnSauceButton() {
        driver.findElement(BUTTON_SAUCE).click();
        return this;
    }
    @Step("Check that Sauce is visible")
    public MainPage checkIsGoToSauce() {
        assertEquals(ERROR_SAUCE_VIS, "Соусы", getTextBySection());
        return this;
    }
    @Step("Click on Filling section")
    public MainPage clickOnFillingButton() {
        driver.findElement((BUTTON_FILLING)).click();
        return this;
    }
    @Step("Check that Filling is visible")
    public MainPage checkIsGoToFilling() {
        assertEquals(ERROR_FILLING_VIS, "Начинки", getTextBySection());
        return this;
    }
    @Step("Click on Bun section")
    public MainPage clickOnBunButton() {
        driver.findElement(BUTTON_BUN).click();
        return this;
    }
    @Step("Check that Bun is visible")
    public MainPage checkIsGoToBun() {
        assertEquals(ERROR_BUN_VIS, "Булки", getTextBySection());
        return this;
    }
    @Step("Scroll down to Sauce")
    public MainPage scrollDownToSauce() {
        ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(SAUCE));
        return this;
    }
    @Step("Scroll down to Filling")
    public MainPage scrollDownToFilling() {
        ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(FILING));
        return this;
    }
    @Step("Scroll Up to Sauce")
    public MainPage scrollUpToSauce() {
        ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(SAUCE));
        return this;
    }
    @Step("Scroll Up to Bun")
    public MainPage scrollUpToBun() {
        ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(BUN));
        return this;
    }
}
