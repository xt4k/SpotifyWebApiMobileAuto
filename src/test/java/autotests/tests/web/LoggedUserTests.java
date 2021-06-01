package autotests.tests.web;

import autotests.po.AccountMenuWidget;
import autotests.po.MainMenuWidget;
import autotests.pojo.web.Playlist;
import autotests.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Feature("Web tests")
@Story("Registered User tests")
@Tags({@Tag("web"), @Tag("spotify_testsuite"), @Tag("logged")})
@Owner("xt4k")
public class LoggedUserTests extends TestBase {
    Playlist playlist = new Playlist();

    @BeforeEach
    void loginAccount() {
        po.loginToAccount();
    }

    @AfterEach
    void logOut() {
        new AccountMenuWidget().logOut();
    }


    @Test
    @DisplayName("Test 02. Create playlist")
    void createPlaylist() {
        new MainMenuWidget().createPlayList()
                .change()
                .setDetails(playlist)
                .save()
                .verifyPlayListInfo(playlist);
    }

    @Test
    @DisplayName("Test 03. Find track")
    void findTrack() {
        new MainMenuWidget().openSearch()
                .search(playlist.getGenre())
                .verifyTrackInfo(playlist.getGenre());
    }

}
