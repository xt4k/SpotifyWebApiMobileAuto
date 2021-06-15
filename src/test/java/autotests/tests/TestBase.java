package autotests.tests;

import autotests.config.testdata.TestData;
import autotests.helpers.Auth;
import autotests.po.pages.BasePage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static autotests.drivers.DriverHelper.*;
import static autotests.helpers.AttachmentsHelper.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    public static BasePage po = new BasePage();
    public static String API_TOKEN;

    @BeforeAll
    static void setUp() {
        if (isUiTest()) {
            configureDriver();
            Configuration.baseUrl = TestData.getWebUrl();
            Configuration.startMaximized = true;
        }
        API_TOKEN = new Auth().getToken();
        RestAssured.baseURI = TestData.getApiUrl();
    }

    @AfterEach
    public void addAttachments() {
        if (isUiTest()) {
            String sessionId = getSessionId();
            attachScreenshot("Last screenshot");
            attachPageSource();
            attachAsText("Browser console logs", getConsoleLogs(sessionId));
            closeWebDriver();
            if (isVideoOn()) attachVideo(sessionId);
        }
    }
}
