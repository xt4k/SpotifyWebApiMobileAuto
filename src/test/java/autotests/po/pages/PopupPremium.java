package autotests.po.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static autotests.helpers.AttachmentsHelper.attachScreenshot;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PopupPremium extends BasePage {
    SelenideElement sePremiumPopup = $("div[role='dialog'][tabindex]");

    @Step("Close Premium popup")
    public void closeIfExistPremiumPopup() {
        if (sePremiumPopup.isDisplayed())
            sePremiumPopup.$$("button").last().click();
        insertCookie();
        sleep(1000);
        attachScreenshot("Premium popup closed");
    }
}
