package autotests.tests.web;

import autotests.annotations.JiraIssue;
import autotests.annotations.JiraIssues;
import autotests.annotations.Layer;
import autotests.annotations.TM4J;
import autotests.po.widgets.AccountMenu;
import autotests.po.widgets.MainMenu;
import autotests.pojo.web.Playlist;
import autotests.tests.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Feature("Web tests")
@Story("Registered User tests")
@Tags({@Tag("web"), @Tag("spotify_testsuite"), @Tag("account")})
@Owner("xt4k")
@Layer("Web")
@JiraIssues({@JiraIssue("AUTO-226")})
@DisplayName("Testset for web UI tests by registered user.")
public class RegisteredUserOpsTests extends TestBase {
    Playlist playlist = new Playlist();

    @BeforeEach
    void loginAccount() {
        po.loginToAccount();
    }

    @AfterEach
    void logOut() {
        new AccountMenu().logOut();
    }

    @Test
    @JiraIssues({@JiraIssue("AUTO-226")})
    @TM4J("2947")
    @Description("Test 11. UI: Create playlist")
    void createPlaylist() {
        new MainMenu().createPlayList()
                .change()
                .setDetails(playlist)
                .save()
                .verifyPlayListInfo(playlist);
    }

    @Test
    @JiraIssues({@JiraIssue("AUTO-226")})
    @TM4J("2948")
    @Description("Test 12. UI: Find track")
    void findTrack() {
        new MainMenu().openSearch()
                .search(playlist.getGenre())
                .verifyTrackInfo(playlist.getGenre());
    }
}
