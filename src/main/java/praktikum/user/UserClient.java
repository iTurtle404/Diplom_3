package praktikum.user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import praktikum.Client;


import static praktikum.constants.URLEndPoints.*;

public class UserClient extends Client {

    @Step("Created new User from random")
    public ValidatableResponse createUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_REGISTER_PATH)
                .then().log().all();
    }
    @Step("Logged User")
    public ValidatableResponse loginUser(Credentials cred) {
        return spec()
                .body(cred)
                .when()
                .post(USER_LOGIN_PATH)
                .then().log().all();
    }
    @Step ("Deleted User with accessToken")
    public void deleteUser(String accessToken) {
        if (accessToken == null) {
            return;
        }
        spec()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_PATH)
                .then().log().all();
    }

    @Step("Get Token")
    public String getAccessToken(Response response) {
        String token = response.then()
                .extract()
                .path("accessToken");
        return token.substring(7);
    }


}
