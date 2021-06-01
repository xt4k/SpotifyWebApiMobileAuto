package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class PopupPremium extends BasePageObject {
    SelenideElement sePopup = $("div[tabindex='-1']");
    SelenideElement seBtnPremium = $(withText("Premium"));

    @Step("Close Premium popup")
    public void closePremiumPopup() {
        attachScreenshot("no cookie");
        insertCookie();
        sePopup.$$("button").last().click();
        attachScreenshot("+ cookie");
    }
}
