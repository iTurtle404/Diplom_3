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
    protected static final By BUTTON_REGA = By.className("Auth_link__1fOlj");
    protected static final By BUTTON_ENTER =By.xpath("//button[text()='Войти']");
    protected static final By INPUT_EMAIL = By.xpath ("//fieldset[1]//input");
    protected static final By INPUT_PASS = By.xpath ("//fieldset[2]//input");
    protected static final By MAIN_PAGE = By.xpath("//h1[text()='Соберите бургер']");
    protected static final By RECOVERY_PASS = By.xpath("//a[text()='Восстановить пароль']");

    //methods
    @Step("Click on Registration button")
    public RegisterPage clickOnRegaButton() {
        driver.findElement(BUTTON_REGA).click();
        return new RegisterPage(driver);
    }

    @Step("Check that is Login Page")
    public LoginPage checkIsLoginPage(){
        assertTrue(ERROR_REGIST, driver.findElements(BUTTON_ENTER).size() != 0);
        return this;
    }

    @Step("Input data in field Email")
    public LoginPage inputEmail(String email){
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        return this;
    }
    @Step("Input data in field Password")
    public LoginPage inputPass(String pass){
        driver.findElement(INPUT_PASS).sendKeys(pass);
        return this;
    }
    @Step("Click on Enter button")
    public LoginPage clickOnButtonEnter(){
        driver.findElement(BUTTON_ENTER).click();
        return this;
    }
    @Step("Check that login is successfully")
    public MainPage checkLoggedSuccess() {
        assertTrue(ERROR_LOGGED, driver.findElements(MAIN_PAGE).size() != 0);
        return new MainPage(driver);
    }
    @Step("Click on Recovery Password")
    public ForgotPage clickOnRecoveryPass(){
        driver.findElement(RECOVERY_PASS).click();
        return new ForgotPage(driver);
    }
}
