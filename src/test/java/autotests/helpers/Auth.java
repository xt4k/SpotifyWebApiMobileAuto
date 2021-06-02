package autotests.helpers;

import autotests.config.testdata.TestData;
import io.qameta.allure.Step;

import static autotests.helpers.LogFilter.filtres;
import static io.restassured.RestAssured.given;

public class Auth {

    @Step("Get session token from spotify")
    public String getToken() {
        return
                given()
                        .filter(filtres().withCustomTemplates())
                        .log().uri()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")//.contentType(ContentType.URLENC)
                        .auth().preemptive().basic(TestData.getClientId(), TestData.getClientSecret())
                        .param("grant_type", "client_credentials")
                        .log()
                        .method()
                        .log()
                        .params()
                        .when()
                        .post(TestData.getApiAuthUrl() + "/token")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().body().path("access_token");
    }
}
