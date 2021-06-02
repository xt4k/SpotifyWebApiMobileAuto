package autotests.tests.api;

import autotests.config.testdata.TestData;
import autotests.pojo.api.search.item.AlbumItem;
import autotests.pojo.api.search.item.Form;
import autotests.tests.TestBase;
import autotests.tests.api.client.SpecClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Api tests")
@Tags({@Tag("api"), @Tag("spotify_testsuite")})
@Owner("xt4k")
@Layer("API")
@JiraIssues({@JiraIssue("AUTO-226")})
class ApiTests extends TestBase {
    private static SpecClient client = new SpecClient();
    protected ObjectMapper mapper = new ObjectMapper();
    private Form form = new Form();
    private Response response;

    @Story("Search")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @DisplayName("Test 01. Api: Search Band's Album.")
    void searchAlbumForBand() {
        AlbumItem ai = new AlbumItem("Nirvana", "Bleach", "album", 13);
        form = new Form(ai, "US", 10, 0);

        step("Check if searched album is found.", () -> {
            response = client.searchItem(form);
        });

        step("Response analysis.", () -> {
            JsonNode childs = response.as(JsonNode.class).path("albums").path("items");
            List<AlbumItem> albList = mapper.readValue(childs.toString(), new TypeReference<List<AlbumItem>>() { });

            Optional<AlbumItem> matchingObject = albList.stream()
                    .filter(album -> album.getName().equals(ai.getName()))
                    .filter(album -> album.getArtists().get(0).getName().equals(ai.getArtists().get(0).getName()))
                    .findAny();

            assertThat(matchingObject).usingRecursiveComparison()
                    .ignoringActualNullFields()
                    .ignoringExpectedNullFields()
                    .isEqualTo(Optional.of(ai));

            addAttachment("Expected Response Item:", valueOf(ai));
            addAttachment("Matched item", valueOf(matchingObject));
        });
    }

    @Story("Security")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @DisplayName("Test 02. API: Check personal info (negative).")
    void getProfileInfo() {
        step("Send request for own personal info.", () -> {
            response = client.getInfo("/me", 401);
        });

        step("Check if actual error message equal to expected.", () -> {
            String message = response.getBody().jsonPath().get("error.message");
            assertThat(message).isEqualTo("Unauthorized.");
        });
    }

    @Story("Read")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @DisplayName("Test 03. API: Check user display name.")
    void getUserProfileInfo() {
        step("Send request for user personal info.", () -> {
            String tail = "/users/" + TestData.getUserId();
            response = client.getInfo(tail, 200);
        });

        step("Check if found user nickname equal to expected.", () -> {
            String displayName = response.getBody().jsonPath().get("display_name");
            assertThat(displayName).isEqualTo(TestData.getUserNickName());
        });
    }

    @Story("Read")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @DisplayName("TEst 04. API: Check if UA market available.")
    void checkUaMarket() {
        step("Send request about markets.", () -> {
            response = client.getInfo("/markets", 200);
        });
        step("Check if expected market present in list.", () -> {
            List<String> markets = response.getBody().jsonPath().getList("markets");
            Optional<String> isUa = markets.stream().filter(m -> m.equals(TestData.getCountryCode())).findAny();
            assertThat(isUa).isNotNull();
        });
    }

    @AfterEach
    public void addAttachments() {
        step("Test completed");
    }

}