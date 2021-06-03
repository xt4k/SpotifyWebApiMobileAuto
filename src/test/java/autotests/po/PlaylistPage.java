package autotests.po;

import autotests.pojo.web.Playlist;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PlaylistPage extends BasePageObject {
    SelenideElement sePlayListTitle = $("h1[dir='auto']");
    SelenideElement sePlayListText = $("h2 span[as='span']");

    @Step("Open 'Change playlist' form")
    public ListDetailsWidget change() {
        sePlayListTitle.click();
        return new ListDetailsWidget();
    }

    @Step("Verify that edited playlist has entered info.")
    public void verifyPlayListInfo(Playlist playlist) {
        sePlayListTitle.shouldHave(text(playlist.getName()));
        sePlayListText.shouldHave(text(playlist.getDescription()));

    }
}
