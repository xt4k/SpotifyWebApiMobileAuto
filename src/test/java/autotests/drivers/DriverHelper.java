package autotests.drivers;

import autotests.config.DriverConfig;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

import static autotests.helpers.BrowserstackHelper.getBSPublicLink;
import static autotests.tests.TestBase.SESSION_ID;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static java.lang.String.join;
import static java.util.Optional.ofNullable;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {

    public static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    public static String getWebRemoteDriver() {  // https://%s:%s@selenoid.autotests.cloud/wd/hub/
        return String.format(getDriverConfig().webRemoteDriverUrl(),
                getDriverConfig().webRemoteDriverUser(),
                getDriverConfig().webRemoteDriverPassword());
    }

    public static boolean isRemoteWebDriver() { return !"".equals(getDriverConfig().webRemoteDriverUrl()); }

    public static String getVideoUrl() { return getDriverConfig().videoStorage(); }

    public static boolean isVideoOn() {return !"".equals(getVideoUrl()); }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public static String getConsoleLogs(String sessionId) {
        String consoleLog;
        if (getDriverConfig().mobileCloud().equals("browserstack"))
           consoleLog = getBSPublicLink(sessionId);
        else {
            String logType = ofNullable(getDriverConfig().browserLogType()).orElse(BROWSER);
            consoleLog = join("\n", getWebDriverLogs(logType));
        }
        return consoleLog;
    }

    @Step("WebDriver configuring")
    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        browser = getDriverConfig().webBrowser();
        browserVersion = getDriverConfig().webBrowserVersion();
        browserSize = getDriverConfig().webBrowserSize();


        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        if ("chrome".equals(getDriverConfig().webBrowser())) {
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.prompt_for_download", false);
            chromeOptions.addArguments("--safebrowsing-disable-download-protection");
            chromeOptions.addArguments("--use-fake-ui-for-media-stream");
            chromeOptions.addArguments("--safebrowsing-disable-extension-blacklist");
            chromeOptions.setExperimentalOption("prefs", prefs);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }

        if (isRemoteWebDriver()) {// selenide
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            remote = getWebRemoteDriver();
        }
        browserCapabilities = capabilities;
    }
}