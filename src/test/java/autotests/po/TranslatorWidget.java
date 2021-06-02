package autotests.po;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static autotests.drivers.DriverHelper.getDriverConfig;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;

public class TranslatorWidget extends BasePageObject {

    //SelenideElement seMicro = $("#ow47");
    SelenideElement seEngText = $("textarea[rows='1']");

    public void prepare() {
        browser = getDriverConfig().webBrowser();
        browserVersion = getDriverConfig().webBrowserVersion();
        browserSize = getDriverConfig().webBrowserSize();
        timeout = 10000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--use-fake-ui-for-media-stream");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        browserCapabilities = capabilities;
        SelenideDriver tab2 = new SelenideDriver(new SelenideConfig().browser(browser));
        tab2.open("https://translate.google.com.ua/?sl=en&tl=ru&op=translate");
        tab2.find("#ow47").click();
        Selenide.switchTo().window(0);
    }

    public String takeSecret() {
        return seEngText.getText();
    }
}
