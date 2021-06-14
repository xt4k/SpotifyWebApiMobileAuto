package autotests.tests.api;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Layer;
import autotests.annotations.TM4J;
import autotests.config.testdata.TestData;
import autotests.pojo.api.search.item.AlbumItem;
import autotests.pojo.api.search.item.Form;
import autotests.tests.TestBase;
import autotests.tests.api.client.SpecClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

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
@DisplayName("Spotify API testet.")
class ApiTests extends TestBase {
    private static SpecClient client = new SpecClient();
    private Response response;

    @Story("Search")
    @TM4J("2942")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @Description("Test 01. API: Search Band's Album.")
    void searchAlbumForBand() {
        AlbumItem ai = new AlbumItem("Nirvana", "Bleach", "album", 13);
        Form form = new Form(ai, "US", 10, 0);

        step("Check if searched album is found.", () -> {
            response = client.searchItem(form);
        });

        step("Response analysis.", () -> {
            JsonNode childs = response.as(JsonNode.class).path("albums").path("items");
            List<AlbumItem> albList = new ObjectMapper().readValue(childs.toString(), new TypeReference<List<AlbumItem>>() { });

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
    @TM4J("2939")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @Description("Test 02. API: Check personal info (negative).")
    void getProfileInfo() {
        step("Send request for own personal info.", () -> {
            response = client.getInfo("/me", 401);
        });

        step("Check if actual error message equal to expected.", () -> {
            String message = response.getBody().path("error.message");
            assertThat(message).isEqualTo("Unauthorized.");
        });
    }

    @Story("Read")
    @TM4J("2941")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @Description("Test 03. API: Check user display name.")
    void getUserProfileInfo() {
        step("Send request for user personal info.", () -> {
            response = client.getInfo("/users/" + TestData.getUserId(), 200);
        });

        step("Check if found user nickname equal to expected.", () -> {
            String displayName = response.getBody().path("display_name");
            assertThat(displayName).isEqualTo(TestData.getUserNickName());
        });
    }

    @Story("Read")
    @TM4J("2940")
    @JiraIssues({@JiraIssue("AUTO-226")})
    @Test
    @Description("Test 04. API: Check if UA market available.")
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
}