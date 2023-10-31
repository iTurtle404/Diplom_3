package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RegisterPage {
    final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    protected static final By INPUT_NAME = By.xpath ("//fieldset[1]//input");
    protected static final By INPUT_EMAIL = By.xpath ("//fieldset[2]//input");
    protected static final By INPUT_PASS = By.xpath ("//fieldset[3]//input");
    protected static final By BUTTON_REGISTER = By.xpath("//button[text()='Зарегистрироваться']");
    protected static final By ERROR_MSG_EXIST_USER = By.xpath(".//*[@class='input__error text_type_main-default']");
    protected static final By ERROR_MSG_LENGHT_PASS = By.xpath(".//p[contains(text(),'Некорректный пароль')]");
    protected static final By BUTTON_ALREADY_REG = By.xpath("//a[text()='Войти']");


    //methods
    @Step("Input Name into registration form")
    public RegisterPage inputName(String name){
        driver.findElement(INPUT_NAME).sendKeys(name);
        return this;
    }
    @Step("Input Email into registration form")
    public RegisterPage inputEmail(String email){
        driver.findElement(INPUT_EMAIL).sendKeys(email);
        return this;
    }
    @Step("Input Password into registration form")
    public RegisterPage inputPass(String pass){
        driver.findElement(INPUT_PASS).sendKeys(pass);
        return this;
    }
    @Step("Check that unsuccessfully registration with existen data")
    public RegisterPage showErrorExistUserMsg(){
        assertTrue( driver.findElements(ERROR_MSG_EXIST_USER).size() != 0);
        return this;

    }
    @Step("Click oh button for registration")
    public LoginPage clickOnRegisterButton() {
        driver.findElement(BUTTON_REGISTER).click();
        return new LoginPage(driver);
    }
    @Step("Check that unsuccessfully registration with incorrect password")
    public RegisterPage showErrorLenghtPass() {
        assertTrue( driver.findElements(ERROR_MSG_LENGHT_PASS).size() != 0);
        return this;
    }
    @Step("Click oh button for enter with exist user from Register Page")
    public LoginPage clickOnEnterButton() {
        driver.findElement(BUTTON_ALREADY_REG).click();
        return new LoginPage(driver);
    }
}
