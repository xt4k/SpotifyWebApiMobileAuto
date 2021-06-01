package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainMenuWidget extends BasePageObject {
    SelenideElement seCreatePlayList = $("button[data-testid='create-playlist-button']");
    SelenideElement seSearch = $("a[href='/search']");

    @Step("Create new playlist")
    public PlaylistPage createPlayList() {
        seCreatePlayList.click();
        return new PlaylistPage();
    }

    @Step("Search track by ")
    public SearchWidget openSearch() {
        seSearch.click();
        return new SearchWidget();
    }

}
