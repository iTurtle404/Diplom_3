package praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.*;
import praktikum.rule.DriverRule;
import praktikum.user.User;
import praktikum.user.UserClient;
import praktikum.user.UserGenerator;

public class LoginTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private final UserClient client = new UserClient();
    private User user;
    public String accessToken;

    @Before
    public void setUp() {
        user = UserGenerator.genericUserRandom();

        ValidatableResponse createResponse = client.createUser(user);
        accessToken = createResponse.extract().path("accessToken");
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            client.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Login from Main button on Main Page")
    @Description("Possible Log in from Main button on Main Page")
    public  void loginFromMainButtonTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }
    @Test
    @DisplayName("Login from Personal Account button")
    @Description("Possible Log in Personal Account button")
    public  void loginFromPersonalAccountTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage= mainPage.clickOnPersAccButtonForLogin() ;
        loginPage.clickOnButtonEnter();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }

    @Test
    @DisplayName("Login from form for Registration")
    @Description("Possible Login from form for Registration")
    public  void loginFromRegistrationTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnLoginButton();
        RegisterPage registerPage = loginPage.clickOnRegaButton();
        loginPage = registerPage.clickOnEnterButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }
    @Test
    @DisplayName("Login from form for recovery password")
    @Description("Possible Log in from form for Registration")
    public  void loginFromRecoveryPassTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnLoginButton();
        ForgotPage forgotPage = loginPage.clickOnRecoveryPass();
        loginPage = forgotPage.clickOnEnterButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter()
                .checkLoggedSuccess();
    }
}
