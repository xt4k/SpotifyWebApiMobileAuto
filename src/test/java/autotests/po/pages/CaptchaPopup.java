package autotests.po.pages;

import autotests.po.widgets.Translator;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CaptchaPopup extends BasePage {
    SelenideElement seAudio = $("#recaptcha-audio-button");
    SelenideElement sePlay = $("button[aria-labelledby='audio-instructions rc-response-label']");
    SelenideElement seAudioResponse = $("#audio-response");
    SelenideElement seConfirm = $("#recaptcha-verify-button");
    ElementsCollection ecCapchaPopup = $$("div [style] iframe");

    public void doTask() {
        switchTo().parentFrame();
        String frameName = ecCapchaPopup.last().getAttribute("name");
        switchTo().innerFrame(frameName);
        seAudio.click();
        sleep(5000);
        new Translator().prepare();
        sePlay.click();
        String secretWord = new Translator().takeSecret();
        seAudioResponse.setValue(secretWord);
        seConfirm.click();
    }
}
