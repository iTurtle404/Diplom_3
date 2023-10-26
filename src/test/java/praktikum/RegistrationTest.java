package praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import user.*;

import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    private final UserClient client = new UserClient();
    private User user;
    public String accessToken;

    public RegistrationTest() {
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            client.deleteUser(accessToken);
        }
    }

    @org.junit.Test
    @DisplayName("Registration user with existen data")
    public void registrationExistUserTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        user = UserGenerator.genericUserRandom();
        client.createUser(user);

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        registerPage.inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnRegisterButton();
       registerPage.showErrorExistUserMsg();

        var creds = Credentials.from(user);
        ValidatableResponse loginResponse = client.loginUser(creds);
        accessToken = loginResponse.extract().path("accessToken");
    }

    @Test
    public void registrationUserWithCorrectTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        user = UserGenerator.genericUserRandom();

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        registerPage.inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword());
        loginPage = registerPage.clickOnRegisterButton();
        loginPage.isLoginPage();

        var creds = Credentials.from(user);
        ValidatableResponse loginResponse = client.loginUser(creds);
        accessToken = loginResponse.extract().path("accessToken");
    }

    @Test
    @DisplayName("")
    public void registrationWithIccorectPassTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        user = UserGenerator.genericUserRandom();
        client.createUser(user);
        user.setPassword("000");

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        registerPage.inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnRegisterButton();
        registerPage.showErrorLenghtPath();

        var creds = Credentials.from(user);
        ValidatableResponse loginResponse = client.loginUser(creds);
        accessToken = loginResponse.extract().path("accessToken");
    }
}
