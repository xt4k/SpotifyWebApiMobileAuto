package autotests.tests.web;

import autotests.po.AccountMenuWidget;
import autotests.po.MainMenuWidget;
import autotests.pojo.web.Playlist;
import autotests.tests.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

@Feature("Web tests")
@Story("Registered User tests")
@Tags({@Tag("web"), @Tag("spotify_testsuite"), @Tag("logged")})
@Owner("xt4k")
@Layer("Web")
@JiraIssues({@JiraIssue("AUTO-226")})
@DisplayName("Testset for web UI tests by registered user.")
public class LoggedUserTests extends TestBase {
    Playlist playlist = new Playlist();

  /*  @BeforeEach
    void loginAccount() { po.loginToAccount(); }*/

    @AfterEach
    void logOut() { new AccountMenuWidget().logOut(); }

    @Test
    @JiraIssues({@JiraIssue("AUTO-226")})
    @TM4J("2947")
    @DisplayName("Test 11. UI: Create playlist")
    void createPlaylist() {
        po.loginToAccount();
        new MainMenuWidget().createPlayList()
                .change()
                .setDetails(playlist)
                .save()
                .verifyPlayListInfo(playlist);
    }

    @Test
    @JiraIssues({@JiraIssue("AUTO-226")})
    @TM4J("2948")
    @DisplayName("Test 12. UI: Find track")
    void findTrack() {
        po.loginToAccount();
        new MainMenuWidget().openSearch()
                .search(playlist.getGenre())
                .verifyTrackInfo(playlist.getGenre());
    }
}
