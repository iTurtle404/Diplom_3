import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import praktikum.user.User;
import praktikum.user.UserClient;

import static praktikum.user.UserGenerator.genericUserRandom;

public class testTest {
    private final UserClient client = new UserClient();
    private User user;
    public String accessToken;
    @Test
    @DisplayName("Check successfully post /api/auth/register")
    @Description("Possible created user with correct data")
    public void createUserPositiveTest(){
        var user = genericUserRandom();
        ValidatableResponse createResponse = client.createUser(user);
        accessToken = createResponse.extract().path("accessToken");

    }
}
