package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Message.ERROR_LOGGED;
import static constants.Message.ERROR_REGIST;
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
    public RegisterPage clickOnRegaButton() {
        driver.findElement(buttonRega).click();
        return new RegisterPage(driver);
    }

    public LoginPage checkIsLoginPage(){
        assertTrue(ERROR_REGIST, driver.findElements(buttonEnter).size() != 0);
        return this;
    }

    public LoginPage inputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
        return this;
    }
    public LoginPage inputPass(String pass){
        driver.findElement(inputPass).sendKeys(pass);
        return this;
    }
    public LoginPage clickOnButtonEnter(){
        driver.findElement(buttonEnter).click();
        return this;
    }
    public MainPage checkLoggedSuccess() {
        assertTrue(ERROR_LOGGED, driver.findElements(mainPage).size() != 0);
        return new MainPage(driver);
    }
    public ForgotPage clickOnRecovPass(){
        driver.findElement(recoveryPass).click();
        return new ForgotPage(driver);
    }
}
