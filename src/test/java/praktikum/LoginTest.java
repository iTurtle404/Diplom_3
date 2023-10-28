package praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pages.*;
import user.Credentials;
import user.User;
import user.UserClient;
import user.UserGenerator;

public class LoginTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private final UserClient client = new UserClient();
    private User user;
    public String accessToken;

    @Before
    public void setUp() {
        user = UserGenerator.genericUserRandom();
        client.createUser(user);

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
    public  void loginInAccountUpLogTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }
    @Test
    public  void loginInAccountPersAccTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }

    @Test
    public  void loginInAccountFromRegaTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        loginPage = registerPage.clickOnEnterButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }
    @Test
    public  void loginInAccountFromRecoveryPassTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        ForgotPage forgotPage = loginPage.clickOnRecovPass();
        loginPage = forgotPage.clickOnEnterButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }
}
