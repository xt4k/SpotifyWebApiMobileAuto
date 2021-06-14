package autotests.po.pages;

import autotests.po.widgets.ListDetails;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Playlist extends BasePage {
    SelenideElement sePlayListTitle = $("h1[dir='auto']");
    SelenideElement sePlayListText = $("button > p");

    @Step("Open 'Change playlist' form")
    public ListDetails change() {
        sePlayListTitle.click();
        return new ListDetails();
    }

    @Step("Verify that edited playlist has entered info.")
    public void verifyPlayListInfo(autotests.pojo.web.Playlist playlist) {
        sePlayListTitle.shouldHave(text(playlist.getName()));
        sePlayListText.shouldHave(text(playlist.getDescription()));
        attachScreenshot("Verify playlist info.");
    }
}
