package praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import user.User;
import user.UserClient;
import user.UserGenerator;

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
    public void goToPersonalAccountTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter();
        mainPage= loginPage.checkLoggedSuccess();
        ProfilePage profilePage = mainPage.clickOnPersAccButton();
        profilePage.checkIntoAccountSuccess();
    }
    @Test
    public void goToConstructorTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
        loginPage.inputEmail(user.getEmail())
                .inputPass(user.getPassword())
                .clickOnButtonEnter();
        mainPage = loginPage.checkLoggedSuccess();
        ProfilePage profilePage = mainPage.clickOnPersAccButton();
        mainPage = profilePage.clickOnConstructor();
        mainPage.checkIsMainPage();
    }

    @Test
    public void logOutTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.openPage();
        LoginPage loginPage = mainPage.clickOnUpLoginButton();
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
