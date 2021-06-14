package autotests.po.widgets;

import autotests.po.pages.BasePage;
import autotests.po.pages.CaptchaPopup;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Capcha extends BasePage {
    SelenideElement seNotBot = $("#rc-anchor-container");
    SelenideElement seCapchaFrame = $("#v2-container [title='reCAPTCHA']");

    @Step("Capcha service operations")
    public void goThrough() {
        String frameName = seCapchaFrame.getAttribute("name");
        switchTo().innerFrame(frameName);
        seNotBot.click();
        new CaptchaPopup().doTask();
    }

}
