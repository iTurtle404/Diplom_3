package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RegisterPage {
    final WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    protected static final By inputName = By.xpath ("//fieldset[1]//input");
    protected static final By inputEmail = By.xpath ("//fieldset[2]//input");
    protected static final By inputPass = By.xpath ("//fieldset[3]//input");
    protected static final By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");
    protected static final By errorMsgExistUser = By.xpath(".//*[@class='input__error text_type_main-default']");

    protected static final By errorMsgLenghtPass = By.xpath(".//p[contains(text(),'Некорректный пароль')]");


    //methods
    public RegisterPage inputName(String name){

        driver.findElement(inputName).sendKeys(name);
        return this;
    }
    public RegisterPage inputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
        return this;
    }
    public RegisterPage inputPass(String pass){
        driver.findElement(inputPass).sendKeys(pass);
        return this;
    }
    public RegisterPage showErrorExistUserMsg(){
        assertTrue( driver.findElements(errorMsgExistUser).size() != 0);
        return this;

    }
    public LoginPage clickOnRegisterButton() {
        driver.findElement(buttonRegister).click();
        return new LoginPage(driver);
    }


    public RegisterPage showErrorLenghtPath() {
        assertTrue( driver.findElements(errorMsgLenghtPass).size() != 0);
        return this;
    }
}
