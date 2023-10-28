package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static praktikum.constants.Message.ERROR_LOGGED;
import static praktikum.constants.Message.ERROR_REGIST;
import static org.junit.Assert.assertTrue;

public class LoginPage {
    final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    protected static final By buttonRega = By.className("Auth_link__1fOlj");
    protected static final By buttonEnter =By.xpath("//button[text()='Войти']");
    protected static final By inputEmail = By.xpath ("//fieldset[1]//input");
    protected static final By inputPass = By.xpath ("//fieldset[2]//input");
    protected static final By mainPage = By.xpath("//h1[text()='Соберите бургер']");
    protected static final By recoveryPass = By.xpath("//a[text()='Восстановить пароль']");

    //methods
    @Step("Click on Registration button")
    public RegisterPage clickOnRegaButton() {
        driver.findElement(buttonRega).click();
        return new RegisterPage(driver);
    }

    @Step("Check that is Login Page")
    public LoginPage checkIsLoginPage(){
        assertTrue(ERROR_REGIST, driver.findElements(buttonEnter).size() != 0);
        return this;
    }

    @Step("Input data in field Email")
    public LoginPage inputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
        return this;
    }
    @Step("Input data in field Password")
    public LoginPage inputPass(String pass){
        driver.findElement(inputPass).sendKeys(pass);
        return this;
    }
    @Step("Click on Enter button")
    public LoginPage clickOnButtonEnter(){
        driver.findElement(buttonEnter).click();
        return this;
    }
    @Step("Check that login is successfully")
    public MainPage checkLoggedSuccess() {
        assertTrue(ERROR_LOGGED, driver.findElements(mainPage).size() != 0);
        return new MainPage(driver);
    }
    @Step("Click on Recovery Password")
    public ForgotPage clickOnRecoveryPass(){
        driver.findElement(recoveryPass).click();
        return new ForgotPage(driver);
    }
}
