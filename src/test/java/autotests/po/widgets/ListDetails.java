package autotests.po.widgets;

import autotests.po.pages.BasePage;
import autotests.po.pages.Playlist;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ListDetails extends BasePage {
    SelenideElement sePlayListNameField = $("input[data-testid='playlist-edit-details-name-input']");
    SelenideElement sePlayListTextField = $("textarea[data-testid='playlist-edit-details-description-input']");
    SelenideElement sePlayListSaveChanges = $("button[data-testid='playlist-edit-details-save-button']");

    @Step("Set playlist's details.")
    public ListDetails setDetails(autotests.pojo.web.Playlist playlist) {
        setSeValue(sePlayListNameField, playlist.getName());
        setSeValue(sePlayListTextField, playlist.getDescription());
        return this;
    }

    @Step("Save changes")
    public Playlist save() {
        sePlayListSaveChanges.click();
        return new Playlist();

    }
}
