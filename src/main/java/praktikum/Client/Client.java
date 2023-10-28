package praktikum.Client;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static praktikum.constants.URLEndPoints.BASE_URL;
import static io.restassured.RestAssured.given;

public class Client {
    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }
}
