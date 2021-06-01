package autotests.po;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CapchaTaskPopup extends BasePageObject {

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
        new TranslatorWidget().prepare();
        sePlay.click();
        String secretWord = new TranslatorWidget().takeSecret();
        seAudioResponse.setValue(secretWord);
        seConfirm.click();
    }
}
