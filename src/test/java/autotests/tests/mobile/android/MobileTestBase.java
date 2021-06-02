package autotests.tests.mobile.android;

import autotests.drivers.MobAndroidDriverHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

import static autotests.drivers.DriverHelper.getConsoleLogs;
import static autotests.drivers.DriverHelper.getSessionId;
import static autotests.helpers.AttachmentsHelper.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class MobileTestBase {

    @BeforeAll
    public static void setUp() {
        addListener("AllureSelenide", new AllureSelenide());
        browser = MobAndroidDriverHelper.class.getName();
        startMaximized = false;
        browserSize = null;
        timeout = 15000;
    }


    @BeforeEach
    void openUp() {
        open();
        ((AndroidDriver) getWebDriver()).startRecordingScreen(new AndroidStartScreenRecordingOptions()
                .withTimeLimit(Duration.ofSeconds(40)));
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Get logs", getConsoleLogs(sessionId));

        String base64output = ((AndroidDriver) getWebDriver()).stopRecordingScreen();
        closeWebDriver();
        saveVideoLocally(sessionId, base64output);
    }
}
