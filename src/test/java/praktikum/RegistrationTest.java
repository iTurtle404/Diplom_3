package praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import user.*;

public class RegistrationTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private final UserClient client = new UserClient();
    private User user;
    public String accessToken;

    @Before
    public void setUp(){
        user = UserGenerator.genericUserRandom();

        var creds = Credentials.from(user);
        ValidatableResponse loginResponse = client.loginUser(creds);
        accessToken = loginResponse.extract().path("accessToken");
    }
    @After
    public void tearDown() {
        if (accessToken != null) {
            client.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("")
    public void registrationUserWithCorrectTest() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        registerPage.inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword());
        loginPage = registerPage.clickOnRegisterButton();
        loginPage.checkIsLoginPage();
    }
    @Test
    @DisplayName("Registration user with existen data")
    public void registrationExistUserTest() {
        client.createUser(user);

        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        registerPage.inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnRegisterButton();
       registerPage.showErrorExistUserMsg();
    }

    @Test
    @DisplayName("")
    public void registrationWithInccorectPassTest() {
        user.setPassword("000");

        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        registerPage.inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnRegisterButton();
        registerPage.showErrorLenghtPath();
    }
}
