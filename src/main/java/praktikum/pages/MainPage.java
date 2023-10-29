package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static praktikum.EnvConfig.BASE_URL;

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
    protected static final By buttonLogIn = By.xpath("//button[text()='Войти в аккаунт']");
    protected static final By buttonPersAcc = By.xpath("//p[text()='Личный Кабинет']");
    protected static final By constructorInfo = By.xpath("//h1[text()='Соберите бургер']");
    protected static final By buttonSauce = By.xpath("//span[text()='Соусы']");
    protected static final By spicySauce = By.xpath("//p[text()='Соус Spicy-X']");
    protected static final By buttonFilling = By.xpath("//span[text()='Начинки']");
    protected static final By beefMeteorStake = By.xpath("//p[text()='Говяжий метеорит (отбивная)']");
    protected static final By buttonBun = By.xpath("//span[text()='Булки']");
    protected static final By fluorBun = By.xpath("//p[text()='Флюоресцентная булка R2-D3']");
    protected static final By Bun = By.xpath("//h2[text()='Булки']");
    protected static final By Sauce = By.xpath("//h2[text()='Начинки']");
    protected static final By Filing = By.xpath("//h2[text()='Соусы']");

    //methods
    @Step("Click on Login button")
    public LoginPage clickOnLoginButton() {
        driver.findElement(buttonLogIn).click();
        return new LoginPage(driver);
    }
    //если пользователь еще не авторизован - клик перекидывает на страницу регистрации
    @Step("Click on Personal Account button with unauthorized user")
    public LoginPage  clickOnPersAccButtonForLogin() {
        driver.findElement(buttonPersAcc).click();
        return new LoginPage (driver);
    }
    //если пользователь уже авторизован - клик перекидывает на страницу профиля
    @Step("Click on Personal Account button for go to Profile. authorized user")
    public ProfilePage clickOnPersAccButtonForProfile() {
        driver.findElement(buttonPersAcc).click();
        return new ProfilePage (driver);
    }
    @Step("Check that is Main Page")
    public MainPage checkIsMainPage() {
        assertTrue(driver.findElements(constructorInfo).size() != 0);
        return this;
    }
    @Step("Click on Sauce section")
    public MainPage clickOnSauceButton() {
        driver.findElement(buttonSauce).click();
        return this;
    }
    @Step("Check that Sauce is visible")
    public MainPage checkIsGoToSauce() {
        assertTrue(driver.findElements(spicySauce).size() != 0);
        return this;
    }
    @Step("Click on Filling section")
    public MainPage clickOnFillingButton() {
        driver.findElement(buttonFilling).click();
        return this;
    }
    @Step("Check that Filling is visible")
    public MainPage checkIsGoToFilling() {
        assertTrue(driver.findElements(beefMeteorStake).size() != 0);
        return this;
    }
    @Step("Click on Bun section")
    public MainPage clickOnBunButton() {
        driver.findElement(buttonBun).click();
        return this;
    }
    @Step("Check that Bun is visible")
    public MainPage checkIsGoToBun() {
        assertTrue(driver.findElements(fluorBun).size() != 0);
        return this;
    }
    @Step("Scroll down to Sauce")
    public Object ScrollDownToSauce() {
        return ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(Sauce));
    }
    @Step("Scroll down to Filling")
    public Object ScrollDownToFilling() {
        return ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(Filing));
    }
    @Step("Scroll Up to Sauce")
    public Object ScrollUpToSauce() {
        return ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(Sauce));
    }
    @Step("Scroll Up to Bun")
    public Object ScrollUpToBun() {
        return ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(Bun));
    }
}
