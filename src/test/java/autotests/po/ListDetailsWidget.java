package autotests.po;

import autotests.pojo.web.Playlist;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ListDetailsWidget extends BasePageObject {
    SelenideElement sePlayListNameField = $("input[data-testid='playlist-edit-details-name-input']");
    SelenideElement sePlayListTextField = $("textarea[data-testid='playlist-edit-details-description-input']");
    SelenideElement sePlayListSaveChanges = $("button[data-testid='playlist-edit-details-save-button']");

    @Step("Set playlist's details: {playlist}")
    public ListDetailsWidget setDetails(Playlist playlist) {
        setSeValue(sePlayListNameField, playlist.getName());
        setSeValue(sePlayListTextField, playlist.getDescription());
        return this;
    }

    @Step("Save changes")
    public PlaylistPage save() {
        sePlayListSaveChanges.click();
        return new PlaylistPage();

    }
}
