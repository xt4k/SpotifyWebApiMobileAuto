package autotests.tests.api.client;

import autotests.pojo.api.search.item.Form;
import autotests.tests.api.spec.Spec;
import io.restassured.response.Response;

public class SpecClient {
    public Response searchItem(Form form) {
        return Spec.requestSpec()
                .when()
                .params("query", form.getQuery(),
                        "type", form.getType(),
                        "market", form.getMarket(),
                        "limit", form.getLimit())
                .get("/search")
                .then()
                .statusCode(200)
                .spec(Spec.responseSpec())
                .log()
                .body()
                .extract()
                .response();
    }

    public Response getInfo(String tail, int code) {
        return Spec.requestSpec()
                .when()
                .get(tail)
                .then()
                .statusCode(code)
                .spec(Spec.responseSpec())
                .log()
                .body()
                .extract()
                .response();
    }
}