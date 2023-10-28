package praktikum;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import praktikum.pages.ProfilePage;
import praktikum.user.User;
import praktikum.user.UserClient;
import praktikum.user.UserGenerator;

public class SomeActionTest {
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
    @DisplayName("Transit to Personal Account from Main Page. Logged user")
    @Description("Possible transit to Personal Account from Main Page. Logged user")
    public void goToPersonalAccountTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter();
        mainPage= loginPage.checkLoggedSuccess();
        ProfilePage profilePage = mainPage.clickOnPersAccButton();
        profilePage.checkIntoAccountSuccess();
    }
    @Test
    @DisplayName("Transit to Constructor from Profile Page. Logged user")
    @Description("Possible transit to Constructor from Profile Page. Logged user")
    public void goToConstructorTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter();
        mainPage = loginPage.checkLoggedSuccess();
        ProfilePage profilePage = mainPage.clickOnPersAccButton();
        mainPage = profilePage.clickOnConstructor();
        mainPage.checkIsMainPage();
    }

    @Test
    @DisplayName("Logout user from Profile Page")
    @Description("Possible logout user Profile Page")
    public void logOutTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter();
        mainPage= loginPage.checkLoggedSuccess();
        ProfilePage profilePage = mainPage.clickOnPersAccButton();
        profilePage.checkIntoAccountSuccess();
        loginPage= profilePage.clickOnExit();
        loginPage.checkIsLoginPage();
    }
}
