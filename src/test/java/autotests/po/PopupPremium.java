package autotests.po;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Selenide.$;

public class PopupPremium extends BasePageObject {
    SelenideElement sePremiumPopup = $("div[role='dialog'][tabindex]");

    @Step("Close Premium popup")
    public void closeIfExistPremiumPopup() {
        if (sePremiumPopup.isDisplayed())
            sePremiumPopup.$$("button").last().click();
        insertCookie();//attachScreenshot("closed");
    }
}
