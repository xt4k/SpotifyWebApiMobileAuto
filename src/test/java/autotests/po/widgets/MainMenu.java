package autotests.po.widgets;

import autotests.po.pages.BasePage;
import autotests.po.pages.Playlist;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainMenu extends BasePage {
    SelenideElement seCreatePlayList = $("button[data-testid='create-playlist-button']");
    SelenideElement seSearch = $("a[href='/search']");

    @Step("Create new playlist")
    public Playlist createPlayList() {
        seCreatePlayList.click();
        return new Playlist();
    }

    @Step("Search track by ")
    public Search openSearch() {
        seSearch.click();
        return new Search();
    }

}
