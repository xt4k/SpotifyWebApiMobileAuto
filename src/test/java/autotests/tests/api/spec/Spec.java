package autotests.tests.api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static autotests.helpers.LogFilter.filtres;
import static autotests.tests.TestBase.API_TOKEN;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.URLENC;

public class Spec {

    public static RequestSpecification requestSpec() {
        return given()
                .contentType(URLENC)
                .baseUri(baseURI)
                .auth().oauth2(API_TOKEN)
                .filter(filtres().withCustomTemplates())
                .log().uri();
    }

    public static RequestSpecification requestJson() {
        return given()
                .contentType(JSON)
                .baseUri(baseURI)
                .filter(filtres().withCustomTemplates())
                .log().uri();
    }

    public static synchronized ResponseSpecification responseSpec() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder().build()
                .expect()
                .headers("server", "envoy",
                        "Alt-Svc", "clear",
                        "Via", "HTTP/2 edgeproxy, 1.1 google");
        return responseSpec;
    }
}